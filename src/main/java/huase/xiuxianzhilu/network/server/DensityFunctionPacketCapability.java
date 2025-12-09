/*
 * Copyright (c) 2018-2020 C4
 *
 * This file is part of Curios, a mod made for Minecraft.
 *
 * Curios is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Curios is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Curios.  If not, see <https://www.gnu.org/licenses/>.
 */

package huase.xiuxianzhilu.network.server;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.DensityFunction;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DensityFunctionPacketCapability {

  private int entityId;
  public long time;
  public long dazuo;
  public long danyao;
  public DensityFunctionPacketCapability(int entityId, DensityFunction densityFunction) {
    this.entityId = entityId;
    this.time = densityFunction.time;
    this.dazuo = densityFunction.dazuo;
    this.danyao = densityFunction.danyao;
  }

  public DensityFunctionPacketCapability(int entityId, long time, long dazuo, long danyao) {
    this.entityId = entityId;
    this.time = time;
    this.dazuo = dazuo;
    this.danyao = danyao;
  }

  public static void encode(DensityFunctionPacketCapability msg, FriendlyByteBuf buf) {
    buf.writeInt(msg.entityId);
    buf.writeLong(msg.time);
    buf.writeLong(msg.dazuo);
    buf.writeLong(msg.danyao);
  }

  public static DensityFunctionPacketCapability decode(FriendlyByteBuf buf) {
    return new DensityFunctionPacketCapability(buf.readInt(),buf.readInt(),buf.readInt(),buf.readInt());
  }

  public static void handle(DensityFunctionPacketCapability msg, Supplier<NetworkEvent.Context> ctx) {
    ctx.get().enqueueWork(() -> {
      ClientLevel world = Minecraft.getInstance().level;

      if (world != null) {
        Entity entity = world.getEntity(msg.entityId);
        if(entity != null){
          PlayerCapability capability = (PlayerCapability) CapabilityUtil.getCapability(entity);
          capability.getDensityFunction().synchronize(msg.time,msg.dazuo,msg.danyao);
        }
      }
    });
    ctx.get().setPacketHandled(true);
  }
}
