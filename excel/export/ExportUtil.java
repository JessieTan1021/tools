package com.smartshop.common.util;

import java.beans.PropertyDescriptor;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;


public class ExportUtil<T> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExportUtil.class);
	
	public void exportCsvFile(OutputStream out,String fileName, List<T> listData,Class<?> entityClass){
		
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out,"GBK"));
			
			List<String> columnFields = createHeader(bufferedWriter,entityClass);//列名
			
			createBody(bufferedWriter, columnFields, listData, entityClass);//创建数据
			
			bufferedWriter.close();
			out.close();
		}catch(Exception e){
			LOGGER.info("export csv fail at method exportCsvFile()"+e.getMessage());
		}
		
	}
	
	/**
	 * 创建列名
	 * @throws IOException 
	 */
	private List<String> createHeader(BufferedWriter writer,Class<?> entityClass){
		List<String> list = new ArrayList<>();
		try{
			Field[] fields = entityClass.getDeclaredFields();
			for(int i = 0; i < fields.length; i++){
				Field f = fields[i];
				if(f.isAnnotationPresent(ExportConfig.class)){
					ExportConfig exportConfig = f.getAnnotation(ExportConfig.class);
					writer.write("\""+ exportConfig.name().toString() + "\"");
					if(i < fields.length - 1){
						writer.write(",");
					}
					list.add(f.getName());
				}
			}
			writer.newLine();
		}catch(Exception e){
			LOGGER.info("export csv fail at method createHeader()"+e.getMessage());
		}
		
		return list;
	}
	
	/**
	 * 写入数据
	 */
	private void createBody(BufferedWriter writer,List<String> columnFields, List<T> listData,Class<?> entityClass){
		try{
			PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(entityClass);
			if(!CollectionUtils.isEmpty(listData)){
				for(T t : listData){
					for(int i = 0; i < columnFields.size(); i++){
						String cName = columnFields.get(i);
						for(PropertyDescriptor pd : pds){
							if(pd.getName().equals(cName)){
								Object ob = pd.getReadMethod().invoke(t);
								String content = ob != null ? ob.toString() : "";
								//System.out.println(cName + "-------" + content);
								writer.write("\""+content + "\"");
								if(i < columnFields.size() - 1){
									writer.write(",");
								}
							}
						}
					}
					writer.newLine();
				}
			}
		}catch(Exception e){
			LOGGER.info("export csv fail at method createBody()"+e.getMessage());
		}
	}
	
	

}
