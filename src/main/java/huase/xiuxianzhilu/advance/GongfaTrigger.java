package huase.xiuxianzhilu.advance;

import com.google.gson.JsonObject;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;

public class GongfaTrigger extends SimpleCriterionTrigger<GongfaTrigger.TriggerInstance> {
    static final ResourceLocation ID = ModMain.prefix("gongfatrigger");

    public ResourceLocation getId() {
        return ID;
    }

    public TriggerInstance createInstance(JsonObject pJson, ContextAwarePredicate pPredicate, DeserializationContext pDeserializationContext) {
        ResourceLocation resourceLocation = ModMain.parse(GsonHelper.getAsString(pJson, "resourcekey"));
        return new TriggerInstance(pPredicate, resourceLocation);
    }

    public void trigger(ServerPlayer serverPlayer, ResourceLocation resourceKey) {
        this.trigger(serverPlayer, (triggerInstance) -> triggerInstance.matches(resourceKey));
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final ResourceLocation resourceKey;

        public TriggerInstance(ContextAwarePredicate p_286423_, ResourceLocation resourceKey) {
            super(GongfaTrigger.ID, p_286423_);
            this.resourceKey = resourceKey;
        }


        public static TriggerInstance createInstance(ResourceKey<GongfaSample> resourceKey) {
            return new TriggerInstance(ContextAwarePredicate.ANY, resourceKey.location());
        }


        public boolean matches(ResourceLocation resourceKey) {
            if (resourceKey != null && this.resourceKey.equals(resourceKey)) {
                return true;
            } else {
                return false;
            }
        }

        public JsonObject serializeToJson(SerializationContext serializationContext) {
            JsonObject jsonobject = super.serializeToJson(serializationContext);

//            Optional<RegistryObject<LingxiuJingjieSample>> any = LingxiujingjieGen.LingxiujingjieBase_REGISTER.getEntries().stream().filter(
//                    c -> c.getKey().equals(resourceKey)
//            ).findAny();
//            ResourceLocation id = any.get().getId();
            jsonobject.addProperty("resourcekey", resourceKey.toString());
            return jsonobject;
        }
    }
}