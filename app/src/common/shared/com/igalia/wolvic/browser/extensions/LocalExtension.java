/* -*- Mode: Java; c-basic-offset: 4; tab-width: 4; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.igalia.wolvic.browser.extensions;

import android.util.Log;

import androidx.annotation.NonNull;

import com.igalia.wolvic.utils.SystemUtils;

import mozilla.components.concept.engine.webextension.WebExtensionRuntime;

/**
 * Feature to install temporary extensions from local add-on files.
 */
public class LocalExtension {

    private static final String LOGTAG = SystemUtils.createLogtag(LocalExtension.class);

    /**
     * Installs the web extension in the runtime through the WebExtensionRuntime install method
     */
    public static void install(@NonNull WebExtensionRuntime runtime, @NonNull String extensionId, @NonNull String extensionUrl) {
        runtime.installWebExtension(extensionId, extensionUrl, webExtension -> {
//            TODO Debug addon installedstate enabled false
//            runtime.enableWebExtension(webExtension, EnableSource.APP_SUPPORT, addon1 -> null, throwable -> {
//                Log.d(LOGTAG, String.valueOf(throwable.getMessage()));
//                return null;
//            });
            Log.i(LOGTAG, extensionId + " from " + extensionUrl + " Web Extension successfully installed");
            return null;
        }, (s, throwable) -> {
            Log.e(LOGTAG, "Error installing the " + extensionId + " from " + extensionUrl + " Web Extension: " + throwable.getLocalizedMessage());
            return null;
        });
    }
}
