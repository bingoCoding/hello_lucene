package com.lp.lucene;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoubleDocValuesField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.junit.Test;

public class HelloWorld {

	public void createIndex(String sourcepath, String indexPath) throws IOException{
		
		Directory dir= FSDirectory.open(Paths.get(indexPath));
		IndexWriterConfig iwc=new IndexWriterConfig(new StandardAnalyzer());
		
		@SuppressWarnings("resource")
		IndexWriter indexWriter=new IndexWriter(dir,iwc);
		File file=new File(sourcepath);
		Document doc=null;
		for(File f : file.listFiles()){
			doc=new Document();
			doc.add(new StringField("name", f.getName(), Store.YES));
			doc.add(new TextField("content",new FileReader(f.getAbsolutePath())));
			doc.add(new DoubleDocValuesField("size", f.getUsableSpace()));
			indexWriter.addDocument(doc);
		}
		//indexWriter.commit();
		indexWriter.close();
	}
	
	public void searchData(String indexpath, String string){
		IndexSearcher searcher=null;
		try {
			Directory dir=SimpleFSDirectory.open(Paths.get(indexpath));
			IndexReader reader=DirectoryReader.open(dir);
			searcher=new IndexSearcher(reader);
			
			QueryParser parser=new QueryParser("content", new StandardAnalyzer());
			Query query=parser.parse(string);
			TopDocs docs=searcher.search(query, 10);
			for(ScoreDoc sd:docs.scoreDocs){
				Document d=searcher.doc(sd.doc);
				System.out.println(d.get("name"));
				System.out.println(d.get("size"));
				System.out.println(d.get("content"));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void search() throws IOException{
		String sourcePath = "D:/java/workspace/javaWorkspace1/lucene_helloword/sourceData";
		String indexPath = "D:/java/workspace/javaWorkspace1/lucene_helloword/indexData";
		new HelloWorld().searchData(indexPath,"Ê¿´ó·ò");
	}
	@Test
	public void index() throws IOException{
		String sourcePath = "D:/java/workspace/javaWorkspace1/lucene_helloword/sourceData";
		String indexPath = "D:/java/workspace/javaWorkspace1/lucene_helloword/indexData";
		new HelloWorld().createIndex(sourcePath,indexPath);
	}
}
