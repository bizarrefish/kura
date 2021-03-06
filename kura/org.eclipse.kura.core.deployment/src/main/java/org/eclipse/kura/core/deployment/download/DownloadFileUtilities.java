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

package org.eclipse.kura.core.deployment.download;

import java.io.File;
import java.io.IOException;

import org.eclipse.kura.core.deployment.install.DeploymentPackageInstallOptions;
import org.eclipse.kura.core.deployment.util.FileUtilities;

public class DownloadFileUtilities extends FileUtilities{
	private static final String JAVA_TEMP_DIR = "java.io.tmpdir";

	//File Management
	public static File getDpDownloadFile(DeploymentPackageInstallOptions options) throws IOException {
		String tempPath= System.getProperty(JAVA_TEMP_DIR);
		String packageFilename;
		if(!options.getSystemUpdate()){
			String dpName= FileUtilities.getFileName(options.getDpName(), options.getDpVersion(), ".dp");
			packageFilename = new StringBuilder().append(tempPath)
					.append(File.separator)
					.append(dpName)
					.toString();
		} else {
			String shName= FileUtilities.getFileName(options.getDpName(), options.getDpVersion(), ".sh");
			packageFilename = new StringBuilder().append(tempPath)
					.append(File.separator)
					.append(shName)
					.toString();
		}

		File localFolder = new File(tempPath);
		String fileName = validateFileName(packageFilename, localFolder.getPath());
		return new File(fileName);
	}

	public static boolean deleteDownloadedFile(DeploymentPackageInstallOptions options) throws IOException {
		File file = getDpDownloadFile(options);
		
		if (file != null &&
			file.exists() &&
			file.isFile()){
			return file.delete();
		}
		
		return false;
	}
	
	private static String validateFileName(String destFileName, String intendedDir) throws IOException{
		File destFile = new File(destFileName);
		String filePath = destFile.getCanonicalPath();

		File iD = new File(intendedDir);
		String canonicalID = iD.getCanonicalPath();

		if (filePath.startsWith(canonicalID)) {
			return filePath;
		} else {
			throw new IOException();
		}
	}
}
