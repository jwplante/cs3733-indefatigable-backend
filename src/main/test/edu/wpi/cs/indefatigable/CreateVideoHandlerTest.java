package edu.wpi.cs.indefatigable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.CreateVideoRequest;
import edu.wpi.cs.indefatigable.http.CreateVideoResponse;
import edu.wpi.cs.indefatigable.http.DeleteVideoRequest;
import edu.wpi.cs.indefatigable.http.DeleteVideoResponse;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class CreateVideoHandlerTest extends LambdaTest {

    @Test
    public void testCreateVideo() {
        File originalFile = new File("src/main/resources/1.ogg");
        String encodedBase64 = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
            byte[] bytes = new byte[(int)originalFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	CreateVideoRequest req = new CreateVideoRequest("JUnit","Nothing","Justin",encodedBase64);
        CreateVideoResponse res = new CreateVideoHandler().handleRequest(req, createContext("create"));
        Assert.assertEquals(200, res.statusCode); //it was created
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DeleteVideoRequest req2 = new DeleteVideoRequest(res.vuid);
        DeleteVideoResponse res2 = new DeleteVideoHandler().handleRequest(req2, createContext("delete"));
        Assert.assertEquals(200, res2.statusCode); //it was deleted
    }
    
}