/*
 * JourneyMap API (http://journeymap.info)
 * http://bitbucket.org/TeamJM/journeymap-api
 *
 * Copyright (c) 2011-2016 Techbrew.  All Rights Reserved.
 * The following limited rights are granted to you:
 *
 * You MAY:
 *  + Write your own code that uses the API source code in journeymap.* packages as a dependency.
 *  + Write and distribute your own code that uses, modifies, or extends the example source code in example.* packages
 *  + Fork and modify any source code for the purpose of submitting Pull Requests to the TeamJM/journeymap-api repository.
 *    Submitting new or modified code to the repository means that you are granting Techbrew all rights to the submitted code.
 *
 * You MAY NOT:
 *  - Distribute source code or classes (whether modified or not) from journeymap.* packages.
 *  - Submit any code to the TeamJM/journeymap-api repository with a different license than this one.
 *  - Use code or artifacts from the repository in any way not explicitly granted by this license.
 *
 */

package journeymap.server.api;

import journeymap.common.api.IJmPlugin;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Interface used by JourneyMap to initialize server plugins and provide the Server API.
 * <p>
 * Implementation classes must have a no-arg constructor and also have the {@link ServerPlugin} annotation.
 */
@ParametersAreNonnullByDefault
public interface IServerPlugin extends IJmPlugin<IServerAPI>
{
    /**
     * Called by JourneyMap during the init phase of Forge mod loading.  Your implementation
     * should retain a reference to the IServerAPI passed in, since that is what your plugin
     * will use to make calls to JourneyMap.
     *
     * @param jmServerApi Server API implementation
     */
    void initialize(final IServerAPI jmServerApi);

    /**
     * Used by JourneyMap to associate your mod id with your plugin instance.
     */
    String getModId();
}
