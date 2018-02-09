package ir.hatamiarash.gitlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ronash.pushe.Pushe;
import ir.hatamiarash.helper.CustomPrimaryDrawerItem;

public class MainActivity extends AppCompatActivity {
	public Drawer result = null;
	
	@BindView(R.id.toolbar)
	public Toolbar toolbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Pushe.initialize(this, true);
		ButterKnife.bind(this);
		
		
		toolbar.setTitle(getResources().getString(R.string.app_name));
		setSupportActionBar(toolbar);
		
		PrimaryDrawerItem item_home = new CustomPrimaryDrawerItem().withIdentifier(1).withName("صفحه اصلی").withIcon(GoogleMaterial.Icon.gmd_home);
		
		
		IDrawerItem items[] = new IDrawerItem[]{
				item_home,
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
							
							}
						}
						return false;
					}
				})
				.withSelectedItem(1)
				.withSavedInstance(savedInstanceState)
				.withDrawerGravity(Gravity.END)
				.build();
	}
}
