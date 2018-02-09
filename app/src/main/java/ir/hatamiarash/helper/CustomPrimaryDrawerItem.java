/*
 * Copyright (c) 2017 - All Rights Reserved - Arash Hatami
 */

package ir.hatamiarash.helper;

import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import ir.hatamiarash.gitlearning.R;

public class CustomPrimaryDrawerItem extends PrimaryDrawerItem {
    @Override
    public int getLayoutRes() {
        return R.layout.custom_material_drawer_item_primary;
    }
    
    @Override
    public int getType() {
        return R.id.material_drawer_item_primary_custom;
    }
}