/**
 * Copyright 2005-2011 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.test.ext.oauth.test.resources;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.ext.oauth.OAuthParameters;
import org.restlet.ext.oauth.OAuthProxy;
import org.restlet.ext.oauth.OAuthUser;
import org.restlet.routing.Router;
import org.restlet.test.ext.oauth.provider.AuthorizationServerTest;

public class OAuthClientTestApplication extends Application {
    private OAuthProxy local;

    private OAuthParameters params;
    
    protected static OAuthUser user;

    @Override
    public synchronized Restlet createInboundRoot() {

        Context ctx = getContext();
        Router router = new Router(ctx);

        params = new OAuthParameters("1234567890", "1234567890",
                AuthorizationServerTest.prot + "://localhost:"
                        + AuthorizationServerTest.serverPort + "/oauth/",
                "foo bar");

        local = new OAuthProxy(params, getContext(), true); // Use basic
        local.setNext(DummyResource.class);
        router.attach("/webclient", local);

        router.attach("/unprotected", DummyResource.class);

        return router;
    }

    
    public String getToken() {
        if (user != null) {
            return user.getAccessToken();
        }
        return null;
    }

    public OAuthUser getUser() {
        if (user != null) {
            return user;
        }
        return null;
    }
    
    public void clearUser(){
        user = null;
    }
    
    
    public OAuthParameters getOauthParameters() {
        return params;
    }
}
