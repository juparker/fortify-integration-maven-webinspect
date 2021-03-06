/*******************************************************************************
 * (c) Copyright 2017 EntIT Software LLC, a Micro Focus company
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including without 
 * limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to 
 * whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY 
 * KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
 * IN THE SOFTWARE.
 ******************************************************************************/
package com.fortify.integration.maven.webinspect.wie;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.fortify.client.wie.connection.WIEAuthenticatingRestConnection;
import com.fortify.integration.maven.webinspect.WIEConnectionRetrieverMaven;

/**
 * Abstract mojo superclass for functionality related to WebInspect Enterprise 
 *
 * @author ruud.senden@hpe.com
 *
 */
public abstract class AbstractWIEMojo extends AbstractMojo {
    /**
     * Root URL of the WebInspect Enterprise scan API instance to be used
     */
    @Parameter(property = "com.fortify.wie.connection", required = true)
    private WIEConnectionRetrieverMaven connRetriever;
    
    protected WIEAuthenticatingRestConnection getWIEConnection() {
    	return connRetriever.getConnection();
    }
    
    protected void logResult(Object result) {
		getLog().info("Result: "+(result==null?"No Contents":result.toString()));
	}
}
