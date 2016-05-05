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

import org.eclipse.kura.KuraException;

public interface MultitonService {
	
	/**
	 * Use this method to retrieve all the multitons created using a specific factory.
	 * @param factoryPid Factory Pid used to create the multiton instances to retrieve
	 * @return list of Object representing the instances created using the factoryPid
	 */
	public Object[] getRegisteredMultitonInstance(String factoryPid);
	
	/**
	 * Create a new instance from a specific factory Pid
	 * @param factoryPid The factory to use for creating the multiton instance
	 * @param takeSnapshot Wheter to write a snapshot after the component has been created or not
	 * @param instanceName The name to assign to the newly created instance
	 * @return A String representing the new Pid assigned by the ConfigAdmin to the newly created component
	 * @throws KuraException If Kura is not able to instantiate a new instance
	 */
	public String newMultitonInstance(String factoryPid, boolean takeSnapshot, String instanceName) throws KuraException;
	
	/**
	 * Removes a specific multiton instance from the Kura service repository.
	 * @param pid Unique Pid for the component, as returned by {@link #newMultitonInstance(String, boolean, String) newMultitonInstance}
	 * @return true if the multiton instance gets successfully removed. False otherwise.
	 */
	public boolean removeMultitonInstance(String pid);
	
	/**
	 * Adds a {@link MultitonRegistrationCallback} to the MultitonService implementation.
	 * @param callback The callback to add to the list
	 */
	public void addMultitonServiceRegistrationCallback(MultitonRegistrationCallback callback);
	
	/**
	 * Removes the specified {@link MultitonRegistrationCallback} from the list of registered callbacks
	 * @param callback The callback to remove
	 */
	public void removeMultitonServiceRegistrationCallback(MultitonRegistrationCallback callback);
}
