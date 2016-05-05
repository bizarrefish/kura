/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech
 *******************************************************************************/
package org.eclipse.kura.multitons;

import org.osgi.framework.ServiceReference;

/**
 * Callback object used to notify Multiton Instances registrations and unregistrations from the MultitonService
 * @author eurotech
 *
 */
public interface MultitonRegistrationCallback {

	/**
	 * Invoked when a new multiton instance is created.
	 * @param pid Pid assigned to te instance by the ConfigAdmin.
	 * @param service The ServiceReference to the newly instantiated component
	 */
	public void MultitonComponentRegistered(String pid, ServiceReference<?> service);
	
	/**
	 * Invoked when a multiton instance is about to be deleted.
	 * @param pid Pid of the multiton instance
	 * @param service ServiceReference to the component that is going to be removed
	 */
	public void MultitonComponentUnregistered(String pid, ServiceReference<?> service);
	
	/**
	 * A String filter used to retrieve registration and unregistration event only from a specific factory
	 * @return String representing the factory to use as a filter for the Registration Callback
	 */
	public String getFactoryPidFilter();
	
}
