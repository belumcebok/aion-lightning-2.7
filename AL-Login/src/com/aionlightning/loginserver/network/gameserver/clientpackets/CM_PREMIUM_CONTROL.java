/**
 * This file is part of aion-lightning <aion-lightning.org>.
 * 
 * aion-lightning is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * aion-lightning is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with aion-lightning.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionlightning.loginserver.network.gameserver.clientpackets;

import com.aionlightning.loginserver.controller.PremiumController;
import com.aionlightning.loginserver.network.gameserver.GsClientPacket;

/**
 * @author KID
 */
public class CM_PREMIUM_CONTROL extends GsClientPacket {

	private int accountId;
	private int requestId;
	private long requiredCost;
	private byte serverId;

	@Override
	protected void readImpl() {
		accountId = readD();
		requestId = readD();
		requiredCost = readQ();
		serverId = (byte)readC();
	}
	
	@Override
	protected void runImpl() {
		PremiumController.getController().requestBuy(accountId, requestId, requiredCost, serverId);
	}
}
