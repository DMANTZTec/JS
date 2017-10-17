package com.java.IndexingSolr;																																					
import org.apache.solr.common.params.ModifiableSolrParams;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class MyJob implements Job 
{
    public void execute(JobExecutionContext jobContext) throws JobExecutionException 
    {
    	String urlString = "http://localhost:8983/solr/jobs";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	ModifiableSolrParams params = new ModifiableSolrParams();
    	params.set("command", "full-import");
    	QueryRequest request = new QueryRequest(params);
    	request.setPath("/dataimport");
    	try
    	{
			solr.request(request);
		} 
    	catch (SolrServerException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
