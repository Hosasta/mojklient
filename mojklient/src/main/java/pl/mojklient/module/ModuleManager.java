package pl.mojklient.module;

import net.minecraft.client.MinecraftClient;
import pl.mojklient.module.impl.AutoSprint;
import pl.mojklient.module.impl.Fly;
import pl.mojklient.module.impl.WaterClutch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public void registerAll() {
        modules.add(new WaterClutch());
        modules.add(new AutoSprint());
        modules.add(new Fly());
    }

    public List<Module> getModules() { return Collections.unmodifiableList(modules); }

    public void handleKeys() {
        for (Module m : modules) {
            while (m.getKey().wasPressed()) m.onKeyPressed();
        }
    }

    public void tick(MinecraftClient client) {
        for (Module m : modules) m.onTick();
    }
}
