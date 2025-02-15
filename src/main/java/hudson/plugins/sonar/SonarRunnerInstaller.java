/*
 * SonarQube Scanner for Jenkins
 * Copyright (C) 2007-2025 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package hudson.plugins.sonar;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.tools.DownloadFromUrlInstaller;
import hudson.tools.ToolInstallation;
import org.kohsuke.stapler.DataBoundConstructor;

/**
* Automatic Sonar scanner installer from repository.codehaus.org.
*/
public class SonarRunnerInstaller extends DownloadFromUrlInstaller {
  @DataBoundConstructor
  public SonarRunnerInstaller(String id) {
    super(id);
  }

  @Extension
  public static final class SonarRunnerInstallerDescriptorImpl extends DownloadFromUrlInstaller.DescriptorImpl<SonarRunnerInstaller> {
    @NonNull
    @Override
    public String getDisplayName() {
      return Messages.InstallFromMavenCentral();
    }

    @Override
    public boolean isApplicable(Class<? extends ToolInstallation> toolType) {
      return toolType == SonarRunnerInstallation.class;
    }

  }
}
