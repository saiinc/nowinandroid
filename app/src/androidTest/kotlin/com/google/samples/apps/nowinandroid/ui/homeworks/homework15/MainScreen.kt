/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.homeworks.homework15

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class MainScreen(semanticsProvider: SemanticsNodeInteractionsProvider) : ComposeScreen<MainScreen>(semanticsProvider) {
    val doneButtonText = KNode(semanticsProvider) {
        hasText("Done")
        useUnmergedTree = true
    }

    val topBarTitle: KNode = child {
        hasTestTag(C.top_Bar_Title)
        useUnmergedTree = true
    }

    val topBarNavigationIcon: KNode = child {
        hasTestTag(C.top_Bar_Navigation_Icon)
        useUnmergedTree = true
    }

    val topBarActionIcon: KNode = child {
        hasTestTag(C.top_Bar_Action_Icon)
        useUnmergedTree = true
    }

    val forYouInterestsItemHeader: KNode = child {
        hasTestTag(C.for_You_Interests_Item_Header)
        useUnmergedTree = true
    }

    val forYouInterestsItemSubtitle: KNode = child {
        hasTestTag(C.for_You_Interests_Item_Subtitle)
        useUnmergedTree = true
    }

    val doneButton: KNode = child {
        hasTestTag(C.done_Button)
        useUnmergedTree = true
    }

    val bottomNavBar: KNode = child {
        hasTestTag("NiaNavItem")
    }
}