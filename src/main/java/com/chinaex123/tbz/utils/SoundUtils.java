package com.chinaex123.tbz.utils;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/**
 * 音效工具类
 * <p>
 * 功能：提供通用的音效播放方法，供附魔系统复用
 */
public class SoundUtils {

    /**
     * 播放音效给玩家
     *
     * @param player     目标玩家
     * @param soundEvent 音效事件
     * @param volume     音量（0.0-1.0）
     * @param pitch      音调（0.5-2.0）
     */
    public static void playSoundForPlayer(Player player, SoundEvent soundEvent, float volume, float pitch) {
        if (player.level() instanceof ServerLevel serverLevel) {
            Vec3 pos = player.position();
            serverLevel.playSound(null, pos.x, pos.y, pos.z, soundEvent, SoundSource.PLAYERS, volume, pitch);
        }
    }

    /**
     * 播放音效给玩家（默认音调和音量）
     *
     * @param player     目标玩家
     * @param soundEvent 音效事件
     */
    public static void playSoundForPlayer(Player player, SoundEvent soundEvent) {
        playSoundForPlayer(player, soundEvent, 1.0f, 1.0f);
    }

    /**
     * 播放音效给玩家周围的所有玩家
     *
     * @param player     目标玩家
     * @param soundEvent 音效事件
     * @param volume     音量（0.0-1.0）
     * @param pitch      音调（0.5-2.0）
     */
    public static void playSoundForNearbyPlayers(Player player, SoundEvent soundEvent, float volume, float pitch) {
        if (player.level() instanceof ServerLevel serverLevel) {
            Vec3 pos = player.position();
            serverLevel.playSound(null, pos.x, pos.y, pos.z, soundEvent, SoundSource.PLAYERS, volume, pitch);
        }
    }
}