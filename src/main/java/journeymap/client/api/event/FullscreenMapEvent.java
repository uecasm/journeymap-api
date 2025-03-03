package journeymap.client.api.event;

import journeymap.client.api.model.IBlockInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.awt.geom.Point2D;

/**
 * Event classes for the Fullscreen map.
 */
public class FullscreenMapEvent extends ClientEvent
{
    private final BlockPos location;

    /**
     * Map clicked event, fired when a user clicks on the map.
     * Can be canceled.
     *
     * @param type     - The event type.
     * @param location - The BlockPos of the click.
     * @param level    - The dimension.
     */
    private FullscreenMapEvent(Type type, BlockPos location, ResourceKey<Level> level)
    {
        super(type, level);
        this.location = location;
    }

    public BlockPos getLocation()
    {
        return location;
    }

    public ResourceKey<Level> getLevel()
    {
        return level;
    }


    /**
     * ClickedEvent, handles mouseclicks pre and post, pre is cancelable post is not.
     */
    public static class ClickEvent extends FullscreenMapEvent
    {
        private final int button;
        private final Point2D.Double mousePosition;

        /**
         * Map clicked event, fired when a user clicks on the map.
         * Can be canceled.
         *
         * @param type          - The type
         * @param location      - The BlockPos of the click.
         * @param level         - The dimension.
         * @param mousePosition - The precalculated scaled mouse position.
         * @param button        - The mouse button.
         */
        private ClickEvent(Type type, BlockPos location, ResourceKey<Level> level, Point2D.Double mousePosition, int button)
        {
            super(type, location, level);
            this.mousePosition = mousePosition;
            this.button = button;
        }

        public double getMouseX()
        {
            return mousePosition.x;
        }

        public double getMouseY()
        {
            return mousePosition.y;
        }

        public Point2D.Double getMousePosition()
        {
            return mousePosition;
        }

        public int getButton()
        {
            return button;
        }

        /**
         * Fired before the click, can be cancelled
         */
        public static class Pre extends ClickEvent
        {

            public Pre(BlockPos location, ResourceKey<Level> level, Point2D.Double mousePosition, int button)
            {
                super(Type.MAP_CLICKED_PRE, location, level, mousePosition, button);
            }
        }

        /**
         * Fired before the click, can not be cancelled
         */
        public static class Post extends ClickEvent
        {

            public Post(BlockPos location, ResourceKey<Level> level, Point2D.Double mousePosition, int button)
            {
                super(Type.MAP_CLICKED_POST, location, level, mousePosition, button);
            }
        }
    }

    /**
     * MouseDraggedEvent, handles mouse dragging pre and post, pre is cancelable post is not.
     */
    public static class MouseDraggedEvent extends FullscreenMapEvent
    {
        private final int button;
        private final Point2D.Double mousePosition;

        /**
         * Map MouseDraggedEvent event, fired when a user drag the mouse on the map.
         * Can be canceled.
         *
         * @param type          - The type
         * @param location      - The BlockPos of the click.
         * @param level         - The dimension.
         * @param mousePosition - The precalculated scaled mouse position.
         * @param button        - The mouse button.
         */
        private MouseDraggedEvent(Type type, BlockPos location, ResourceKey<Level> level, Point2D.Double mousePosition, int button)
        {
            super(type, location, level);
            this.mousePosition = mousePosition;
            this.button = button;
        }

        public double getMouseX()
        {
            return mousePosition.x;
        }

        public double getMouseY()
        {
            return mousePosition.y;
        }

        public Point2D.Double getMousePosition()
        {
            return mousePosition;
        }

        public int getButton()
        {
            return button;
        }

        /**
         * Fired at the start of the drag, can be cancelled
         */
        public static class Pre extends MouseDraggedEvent
        {

            public Pre(BlockPos location, ResourceKey<Level> level, Point2D.Double mousePosition, int button)
            {
                super(Type.MAP_DRAGGED_PRE, location, level, mousePosition, button);
            }
        }

        /**
         * Fired at the end of the drag, when user releases mouse button, can not be cancelled
         */
        public static class Post extends MouseDraggedEvent
        {

            public Post(BlockPos location, ResourceKey<Level> level, Point2D.Double mousePosition, int button)
            {
                super(Type.MAP_DRAGGED_POST, location, level, mousePosition, button);
            }
        }
    }

    /**
     * MouseDraggedEvent, handles mouse dragging pre and post, pre is cancelable post is not.
     */
    public static class MouseMoveEvent extends FullscreenMapEvent
    {
        private final Point2D.Double mousePosition;
        private final IBlockInfo info;

        /**
         * Map clicked event, fired when a user clicks on the map.
         * Can be canceled.
         *
         * @param info  - The BlockInfo.
         * @param level - The dimension.
         */
        public MouseMoveEvent(ResourceKey<Level> level, IBlockInfo info, Point2D.Double mousePosition)
        {
            super(Type.MAP_MOUSE_MOVED, info.getBlockPos(), level);
            this.mousePosition = mousePosition;
            this.info = info;
        }

        public Point2D.Double getMousePosition()
        {
            return mousePosition;
        }

        public double getMouseX()
        {
            return mousePosition.x;
        }

        public double getMouseY()
        {
            return mousePosition.y;
        }

        public IBlockInfo getInfo()
        {
            return info;
        }
    }
}
