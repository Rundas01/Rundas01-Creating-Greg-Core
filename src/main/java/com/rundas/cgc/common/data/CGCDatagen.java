package com.rundas.cgc.common.data;

import com.rundas.cgc.CreatingGregCore;
import com.rundas.cgc.common.tag.CGCTagsHandler;
import com.tterrag.registrate.providers.ProviderType;

public class CGCDatagen {

    public static void init() {
        CreatingGregCore.CGC_REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, CGCTagsHandler::initItem);
        CreatingGregCore.CGC_REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, CGCTagsHandler::initBlock);
        CreatingGregCore.CGC_REGISTRATE.addDataGenerator(ProviderType.FLUID_TAGS, CGCTagsHandler::initFluid);
        CreatingGregCore.CGC_REGISTRATE.addDataGenerator(ProviderType.LANG, CGCLangHandler::init);
    }
}
