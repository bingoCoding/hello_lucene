package com.lp.lucene.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoubleDocValuesField;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexableField;

public class LuceneUtils {

	public static Document file2Doc(String sourcepath) throws FileNotFoundException {
		File file=new File(sourcepath);
		Document doc=null;
		for(File f : file.listFiles()){
			doc=new Document();
			doc.add(new StringField("name", f.getName(), Store.YES));
			doc.add(new TextField("content",new FileReader(f.getAbsolutePath())));
			doc.add(new DoubleDocValuesField("size", f.getUsableSpace()));
		}
		
		return doc;
	}

}
