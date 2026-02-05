package huase.xiuxianzhilu.screen;

import net.minecraft.network.chat.Component;

public record ButtonMenu(int left, int top, int width, int height, Task clentrun, Task serverrun, Component pMessage) {
    public interface Task {
        void task();
    }
}
