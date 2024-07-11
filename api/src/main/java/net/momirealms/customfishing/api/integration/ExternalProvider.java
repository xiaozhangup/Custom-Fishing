/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customfishing.api.integration;

/**
 * The ExternalProvider interface serves as a base interface for various external
 * providers in the CustomFishing plugin. It defines a method to retrieve the
 * identification string of the provider, which can be used to distinguish between
 * different providers.
 */
public interface ExternalProvider {

    /**
     * Gets the identification of the external provider.
     *
     * @return The identification string of the external provider.
     */
    String identifier();
}
