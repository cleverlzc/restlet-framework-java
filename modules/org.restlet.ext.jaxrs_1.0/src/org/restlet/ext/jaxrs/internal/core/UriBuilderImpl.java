/**
 * Copyright 2005-2008 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of the following open
 * source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.gnu.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.sun.com/cddl/cddl.html
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royaltee free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */
package org.restlet.ext.jaxrs.internal.core;

import javax.ws.rs.core.UriBuilder;

import org.restlet.ext.jaxrs.AbstractUriBuilder;

/**
 * Implementation of interface {@link UriBuilder}.
 * 
 * @author Stephan Koops
 * @see UriBuilder
 */
public class UriBuilderImpl extends AbstractUriBuilder {
    /**
     * Create a copy of the UriBuilder preserving its state. This is a more
     * efficient means of creating a copy than constructing a new UriBuilder
     * from a URI returned by the {@link #build} method.
     * 
     * @return a copy of the UriBuilder
     * @see javax.ws.rs.core.UriBuilder#clone()
     */
    @Override
    public UriBuilder clone() {
        final UriBuilderImpl uriBuilder = new UriBuilderImpl();
        copyInto(uriBuilder);
        return uriBuilder;
    }
}