/*
 *
 * JourneyMap API
 * http://journeymap.info
 * http://bitbucket.org/TeamJM/journeymap-api
 *
 * Copyright (c) 2011-2015 Techbrew.  All Rights Reserved.
 * The following limited rights are granted to you:
 *
 * You MAY:
 *   + Write your own code that uses this API source code as a dependency.
 *   + Distribute compiled classes of unmodified API source code which your code depends upon.
 *   + Fork and modify API source code for the purpose of submitting Pull Requests to the
 *        TeamJM/journeymap-api repository.  Submitting new or modified code to the repository
 *        means that you are granting Techbrew all rights over the code.
 *
 * You MAY NOT:
 *   - Submit any code to the TeamJM/journeymap-api repository with a different license than this one.
 *   - Distribute modified versions of the API source code or compiled artifacts of  modified API
 *        source code.  In this context, "modified" means changes which have not been both approved
 *        and merged into the TeamJM/journeymap-api repository.
 *   - Use or distribute the API code in any way not explicitly granted by this license statement.
 *
 */

package journeymap.api.client.v1;

import java.util.List;

/**
 * Definition for the JourneyMap Client API v1
 */
public interface ClientAPI
{
    /**
     * The highest API version present in the JourneyMap client mod.
     *
     * @return the highest version
     */
    public int getMaxApiVersion();

    /**
     * Check whether player will accept waypoint additions/removals by your mod.
     *
     * @param modId Mod id
     * @return true if player accepts addition/removal of waypoints
     */
    public boolean checkPlayerWaypointOptIn(String modId);

    /**
     * Check whether player will accept map overlays (markers and polygons) from your mod.
     *
     * @param modId Mod id
     * @return true if player accepts display of map overlays
     */
    public boolean checkPlayerMapOverlayOptIn(String modId);

    /**
     * Add a waypoint for the player. If checkPlayerWaypointOptIn returns false,
     * this method does nothing.  Also note that just because a player accepts
     * a suggested waypoint, doesn't mean they'll keep it forever.
     *
     * @param modId         Mod id
     * @param waypointDefinition Specification for the waypoint to display.
     * @see #checkPlayerWaypointOptIn(String)
     */
    public void addWaypoint(String modId, WaypointDefinition waypointDefinition);

    /**
     * Remove a player's waypoint, if it exists. If checkPlayerWaypointOptIn returns false,
     * this method does nothing.
     *
     * @param modId      Mod id
     * @param waypointId A unique id (within your mod) for the waypoint.
     * @see #checkPlayerWaypointOptIn(String)
     */
    public void removeWaypoint(String modId, String waypointId);

    /**
     * Check whether the player has a waypoint with the given waypointId associated with your mod.
     * If checkPlayerWaypointOptIn returns false, this method does nothing.
     *
     * @param modId      Mod id
     * @param waypointId A unique id (within your mod) for the waypoint.
     * @return true if a waypoint with the id exists.
     */
    public boolean getWaypointExists(String modId, String waypointId);

    /**
     * Gets a list of player waypoint ids associated with your mod.
     * If checkPlayerWaypointOptIn returns false, this method does nothing.
     *
     * @param modId Mod id
     * @return A list, possibly empty.
     * @see #checkPlayerWaypointOptIn(String)
     */
    public List<String> getWaypointIds(String modId);

    /**
     * Attempt to show a marker on one or more map views. If checkPlayerMapOverlayOptIn returns false,
     * this method does nothing.
     * <p/>
     * If a MarkerOverlay with the same markerId already exists, the new one will replace the old one.
     *
     * @param modId         Mod id
     * @param markerOverlay Specification for the map marker.
     * @see #checkPlayerMapOverlayOptIn(String)
     */
    public void addMarker(String modId, MarkerOverlay markerOverlay);

    /**
     * Remove a MarkerOverlay, if it exists. If checkPlayerMapOverlayOptIn returns false,
     * this method does nothing.
     *
     * @param modId    Mod id
     * @param markerId A unique id (within your mod) for the map marker.
     */
    public void removeMarker(String modId, String markerId);

    /**
     * Check whether the player has a map marker with the given markerId associated with your mod.
     * If checkPlayerMapOverlayOptIn returns false, this method returns false.
     *
     * @param modId    Mod id
     * @param markerId A unique id (within your mod) for the MarkerOverlay.
     * @return true if a waypoint with the id exists.
     */
    public boolean getMarkerExists(String modId, String markerId);

    /**
     * Gets a list of MarkerOverlay ids associated with your mod.
     * If checkPlayerWaypointOptIn returns false, an empty list will be returned.
     *
     * @param modId Mod id
     * @return A list, possibly empty.
     */
    public List<String> getMarkerIds(String modId);

    /**
     * Attempt to show a image on one or more map views.  If checkPlayerMapOverlayOptIn returns false,
     * this method does nothing.
     * <p/>
     * If an ImageOverlay with same imageId already exists, the new one will replace the old one.
     *
     * @param modId        Mod id
     * @param imageOverlay Specification for the map image.
     * @see #checkPlayerMapOverlayOptIn(String)
     */
    public void addImage(String modId, ImageOverlay imageOverlay);

    /**
     * Remove an ImageOverlay, if it exists. If checkPlayerMapOverlayOptIn returns false,
     * this method does nothing.
     *
     * @param modId   Mod id
     * @param imageId A unique id (within your mod) for the map image.
     */
    public void removeImage(String modId, String imageId);

    /**
     * Check whether the player has an ImageOverlay with the given imageId associated with your mod.
     * If checkPlayerMapOverlayOptIn returns false, this method returns false.
     *
     * @param modId   Mod id
     * @param imageId A unique id (within your mod) for the map image.
     * @return true if a waypoint with the id exists.
     */
    public boolean getImageExists(String modId, String imageId);

    /**
     * Gets a list of ImageOverlay imageIds associated with your mod. If checkPlayerMapOverlayOptIn returns false,
     * an empty list will be returned.
     *
     * @param modId Mod id
     * @return A list, possibly empty.
     */
    public List<String> getImageIds(String modId);
    
    /**
     * Attempt to show a PolygonOverlay on one or more map views.  If checkPlayerMapOverlayOptIn returns false,
     * this method does nothing.
     * <p/>
     * If a PolygonOverlay with the same polygonId already exists, the new one will replace the old one.
     *
     * @param modId         Mod id
     * @param polygonOverlay Specification of the polygon to display
     * @see #checkPlayerMapOverlayOptIn(String)
     */
    public void addPolygon(String modId, PolygonOverlay polygonOverlay);

    /**
     * Remove a PolygonOverlay, if it exists. If checkPlayerMapOverlayOptIn returns false,
     * this method does nothing.
     *
     * @param modId     Mod id
     * @param polygonId A unique id (within your mod) for the polygon.
     */
    public void removePolygon(String modId, String polygonId);

    /**
     * Check whether the player has a PolygonOverlay with the given polygonId associated with your mod.
     * If checkPlayerMapOverlayOptIn returns false, this method returns false.
     *
     * @param modId     Mod id
     * @param polygonId A unique id (within your mod) for the polygon.
     * @return true if a polygon with the id exists.
     */
    public boolean getPolygonExists(String modId, String polygonId);

    /**
     * Gets a list of PolygonOverlay polygonIds associated with your mod.  If checkPlayerMapOverlayOptIn
     * returns false, an empty list will be returned.
     *
     * @param modId Mod id
     * @return A list, possibly empty.
     */
    public List<String> getPolygonIds(String modId);

}
