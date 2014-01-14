/*
 * Copyright 2000-2013 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.sass.internal.handler;

import java.io.PrintStream;

import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.CSSParseException;
import org.w3c.css.sac.ErrorHandler;

public class SCSSErrorHandler implements ErrorHandler {

    private PrintStream errorStream;

    public SCSSErrorHandler(PrintStream errorStream) {
        this.errorStream = errorStream;
    }

    public SCSSErrorHandler() {
        this(System.out);
    }

    @Override
    public void error(CSSParseException arg0) throws CSSException {
        errorStream.println("Error when parsing file \n" + arg0.getURI()
                + " on line " + arg0.getLineNumber() + ", column "
                + arg0.getColumnNumber());
        errorStream.println(arg0.getMessage() + "\n");
    }

    @Override
    public void fatalError(CSSParseException arg0) throws CSSException {
        errorStream.println("FATAL Error when parsing file \n" + arg0.getURI()
                + " on line " + arg0.getLineNumber() + ", column "
                + arg0.getColumnNumber());
        errorStream.println(arg0.getMessage() + "\n");
    }

    @Override
    public void warning(CSSParseException arg0) throws CSSException {
        errorStream.println("Warning when parsing file \n" + arg0.getURI()
                + " on line " + arg0.getLineNumber() + ", column "
                + arg0.getColumnNumber());
        errorStream.println(arg0.getMessage() + "\n");
    }

}
