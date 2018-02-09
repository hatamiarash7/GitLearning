package ir.hatamiarash.gitlearning;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ronash.pushe.Pushe;
import ir.hatamiarash.adapter.ItemAdapter;
import ir.hatamiarash.helper.CustomPrimaryDrawerItem;
import ir.hatamiarash.helper.DialogHelper;
import ir.hatamiarash.helper.FontHelper;
import ir.hatamiarash.helper.Helper;
import ir.hatamiarash.models.Item;
import ir.hatamiarash.utils.Items;
import ir.hatamiarash.utils.TAGs;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
	public Drawer result = null;
	private List<Item> itemList;
	private ItemAdapter itemAdapter;
	static Typeface persianTypeface;
	
	@BindView(R.id.toolbar)
	public Toolbar toolbar;
	@BindView(R.id.list)
	public RecyclerView list;
	
	private long back_pressed;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Pushe.initialize(this, true);
		ButterKnife.bind(this);
		CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
				.setDefaultFontPath("fonts/iransans.ttf")
				.setFontAttrId(R.attr.fontPath)
				.build()
		);
		
		persianTypeface = Typeface.createFromAsset(getAssets(), FontHelper.FontPath);
		
		toolbar.setTitle(FontHelper.getSpannedString(getApplicationContext(), getResources().getString(R.string.app_name)));
		setSupportActionBar(toolbar);
		
		PrimaryDrawerItem item_home = new CustomPrimaryDrawerItem().withIdentifier(1).withName("صفحه اصلی").withIcon(GoogleMaterial.Icon.gmd_home);
		PrimaryDrawerItem item_about = new CustomPrimaryDrawerItem().withIdentifier(2).withName("درباره ما").withIcon(GoogleMaterial.Icon.gmd_info);
		
		
		IDrawerItem items[] = new IDrawerItem[]{
				item_home,
				item_about,
		};
		
		result = new DrawerBuilder()
				.withActivity(this)
				.withAccountHeader(new AccountHeaderBuilder()
						.withActivity(this)
						.withHeaderBackground(R.drawable.drawer_header)
						.build())
				.addDrawerItems(
						(IDrawerItem[]) (items)
				)
				.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
					@Override
					public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
						if (drawerItem != null) {
							long item = drawerItem.getIdentifier();
							if (item == 1) {
								Intent intent = new Intent(getApplicationContext(), MainActivity.class);
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(intent);
								finish();
							}
							if(item == 2){
								DialogHelper.showAboutDialog(MainActivity.this);
							}
						}
						return false;
					}
				})
				.withSelectedItem(1)
				.withSavedInstance(savedInstanceState)
				.withDrawerGravity(Gravity.END)
				.build();
		
		itemList = new ArrayList<>();
		itemAdapter = new ItemAdapter(this, itemList);
		itemAdapter.setHasStableIds(true);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		list.setLayoutManager(linearLayoutManager);
		list.setItemAnimator(new DefaultItemAnimator());
		list.setAdapter(itemAdapter);
		
		LoadItems();
	}
	
	private void LoadItems() {
		for (String[] item : Items.items) {
			itemList.add(new Item(item[0], item[1]));
		}
		itemAdapter.notifyDataSetChanged();
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.my_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.drawer) {
			result.openDrawer();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		if (back_pressed + 2000 > System.currentTimeMillis()) {
			super.onBackPressed();
			android.os.Process.killProcess(android.os.Process.myPid());
		} else {
			result.closeDrawer();
			Helper.MakeToast(getApplicationContext(), "برای خروج دوباره کلیک کنید", TAGs.WARNING);
		}
		back_pressed = System.currentTimeMillis();
	}
}
