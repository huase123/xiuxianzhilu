package huase.xiuxianzhilu.worlds.multinoisebiomesourceparameterlists;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * - @description:ChangeByname类
 */
public class ChangeByname {
    public static void changeByname() throws Exception {
        // 获取目标类
        Class<?> targetClass = MultiNoiseBiomeSourceParameterList.Preset.class;

        // 获取私有静态字段
        Field byNameField = targetClass.getDeclaredField("BY_NAME");
        byNameField.setAccessible(true);

        // 获取原始Map
        Map<?, ?> originalMap = (Map<?, ?>) byNameField.get(null);


        // 创建新Map并添加修改项
        Map<Object, Object> newMap = new HashMap<>(originalMap);
        newMap.put(MultiNoiseBiomeSourceParameterListGen.xiexianjiemultinoisebiome.id(),MultiNoiseBiomeSourceParameterListGen.xiexianjiemultinoisebiome);

//        Map<?, ?> newMap = Stream.of(NETHER, OVERWORLD,MultiNoiseBiomeSourceParameterListGen.xiexianjiemultinoisebiome).collect(Collectors.toMap(MultiNoiseBiomeSourceParameterList.Preset::id, (p_275365_) -> {
//            return p_275365_;
//        }));
        // 通过反射修改字段值
        byNameField.set(null, newMap);

        // 验证修改结果
        System.out.println(targetClass.getMethod("getPreset", ResourceLocation.class)
                .invoke(null, new ResourceLocation("new_id")));
    }
}
