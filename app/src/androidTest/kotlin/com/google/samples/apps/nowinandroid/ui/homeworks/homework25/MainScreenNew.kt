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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework25

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.C
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListLengthSemantics
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

class MainScreenNew(semanticsProvider: SemanticsNodeInteractionsProvider,
    override val screenName: String = "Главный экран"
) : NamedComposeScreen<MainScreenNew>(semanticsProvider) {

    val lazyHorizontalList by lazy {
        KLazyListNode(
            semanticsProvider = semanticsProvider,
            viewBuilderAction = { hasTestTag("forYou:topicSelection") },
            itemTypeBuilder = {
                itemType(::LazyHorizontalListItemNode)
            },
            positionMatcher = { position ->
                SemanticsMatcher.expectValue(
                    LazyListItemPositionSemantics,
                    position
                )
            },
            lengthSemanticsPropertyKey = LazyListLengthSemantics
        ).name(withParent("Список топиков"))
    }

    fun lazyHorizontalListItemNode(index: Int, function: LazyHorizontalListItemNode.() -> Unit) {
        lazyHorizontalList.invokeAtIndex(index, function)
    }

    val lazyVerticalList by lazy {
        KLazyListNode(
            semanticsProvider = semanticsProvider,
            viewBuilderAction = { hasTestTag("forYou:feed") },
            itemTypeBuilder = {
                itemType(::LazyVerticalListNode)
            },
            positionMatcher = { position ->
                SemanticsMatcher.expectValue(
                    LazyListItemPositionSemantics,
                    position
                )
            },
            lengthSemanticsPropertyKey = LazyListLengthSemantics
        ).name(withParent("Список контента"))
    }

    fun lazyVerticalListItemNode(index: Int, function: LazyVerticalListNode.() -> Unit) {
        lazyVerticalList.invokeAtIndex(index, function)
    }

    val bottomNavBar by lazy {
        child<KNode> {
            hasTestTag("NiaNavItem")
            useUnmergedTree = true
        }.name(withParent("Нижнее меню"))
    }
}

class LazyHorizontalListItemNode(
    semanticsNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider,
) : KLazyListItemNode<LazyHorizontalListItemNode>(semanticsNode, semanticsProvider) {
    val topicIcon by lazy {
        child<KNode> {
            hasTestTag(C.lazy_List_Horisontal_Item_Topic_Icon)
        }.name(withParent("Иконка"))
    }

    val text by lazy {
        child<KNode> {
            hasTestTag(C.lazy_List_Horisontal_Item_Text)
        }.name(withParent("Текст"))
    }

    val toggleButton by lazy {
        child<KNode> {
            hasTestTag(C.lazy_List_Horisontal_Item_Toggle)
        }.name(withParent("Переключатель"))
    }
}

class LazyVerticalListNode(
    semanticsNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider,
) : KLazyListItemNode<LazyVerticalListNode>(semanticsNode, semanticsProvider) {

    val title by lazy {
        child<KNode> {
            hasTestTag(C.lazy_List_Header_Title)
        }.name(withParent("Заголовок"))
    }

    val metadata by lazy {
        child<KNode> {
            hasTestTag(C.lazy_List_Item_Metadata)
        }.name(withParent("Метаданные"))
    }

    val content by lazy {
        child<KNode> {
            hasTestTag(C.lazy_List_Item_Content)
        }.name(withParent("Текст"))
    }
}