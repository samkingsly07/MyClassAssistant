package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.design.C0052R;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.ThemeEnforcement;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.WindowInsetsCompat;
import android.support.p003v7.appcompat.C0400R;
import android.support.p003v7.content.res.AppCompatResources;
import android.support.p003v7.view.SupportMenuInflater;
import android.support.p003v7.view.menu.MenuBuilder;
import android.support.p003v7.view.menu.MenuItemImpl;
import android.support.p003v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private final NavigationMenuPresenter presenter;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, C0052R.attr.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ColorStateList itemIconTint;
        this.presenter = new NavigationMenuPresenter();
        this.menu = new NavigationMenu(context);
        TintTypedArray a = ThemeEnforcement.obtainTintedStyledAttributes(context, attrs, C0052R.styleable.NavigationView, defStyleAttr, C0052R.style.Widget_Design_NavigationView, new int[0]);
        ViewCompat.setBackground(this, a.getDrawable(C0052R.styleable.NavigationView_android_background));
        if (a.hasValue(C0052R.styleable.NavigationView_elevation)) {
            ViewCompat.setElevation(this, (float) a.getDimensionPixelSize(C0052R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows(this, a.getBoolean(C0052R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = a.getDimensionPixelSize(C0052R.styleable.NavigationView_android_maxWidth, 0);
        if (a.hasValue(C0052R.styleable.NavigationView_itemIconTint)) {
            itemIconTint = a.getColorStateList(C0052R.styleable.NavigationView_itemIconTint);
        } else {
            itemIconTint = createDefaultColorStateList(16842808);
        }
        boolean textAppearanceSet = false;
        int textAppearance = 0;
        if (a.hasValue(C0052R.styleable.NavigationView_itemTextAppearance)) {
            textAppearance = a.getResourceId(C0052R.styleable.NavigationView_itemTextAppearance, 0);
            textAppearanceSet = true;
        }
        ColorStateList itemTextColor = a.hasValue(C0052R.styleable.NavigationView_itemTextColor) ? a.getColorStateList(C0052R.styleable.NavigationView_itemTextColor) : null;
        if (!textAppearanceSet && itemTextColor == null) {
            itemTextColor = createDefaultColorStateList(16842806);
        }
        Drawable itemBackground = a.getDrawable(C0052R.styleable.NavigationView_itemBackground);
        if (a.hasValue(C0052R.styleable.NavigationView_itemHorizontalPadding)) {
            this.presenter.setItemHorizontalPadding(a.getDimensionPixelSize(C0052R.styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int itemIconPadding = a.getDimensionPixelSize(C0052R.styleable.NavigationView_itemIconPadding, 0);
        this.menu.setCallback(new MenuBuilder.Callback() {
            public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                return NavigationView.this.listener != null && NavigationView.this.listener.onNavigationItemSelected(item);
            }

            public void onMenuModeChange(MenuBuilder menu) {
            }
        });
        this.presenter.setId(1);
        this.presenter.initForMenu(context, this.menu);
        this.presenter.setItemIconTintList(itemIconTint);
        if (textAppearanceSet) {
            this.presenter.setItemTextAppearance(textAppearance);
        }
        this.presenter.setItemTextColor(itemTextColor);
        this.presenter.setItemBackground(itemBackground);
        this.presenter.setItemIconPadding(itemIconPadding);
        this.menu.addMenuPresenter(this.presenter);
        addView((View) this.presenter.getMenuView(this));
        if (a.hasValue(C0052R.styleable.NavigationView_menu)) {
            inflateMenu(a.getResourceId(C0052R.styleable.NavigationView_menu, 0));
        }
        if (a.hasValue(C0052R.styleable.NavigationView_headerLayout)) {
            inflateHeaderView(a.getResourceId(C0052R.styleable.NavigationView_headerLayout, 0));
        }
        a.recycle();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        state.menuState = new Bundle();
        this.menu.savePresenterStates(state.menuState);
        return state;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable savedState) {
        if (!(savedState instanceof SavedState)) {
            super.onRestoreInstanceState(savedState);
            return;
        }
        SavedState state = (SavedState) savedState;
        super.onRestoreInstanceState(state.getSuperState());
        this.menu.restorePresenterStates(state.menuState);
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener listener2) {
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthSpec, int heightSpec) {
        int mode = View.MeasureSpec.getMode(widthSpec);
        if (mode == Integer.MIN_VALUE) {
            widthSpec = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(widthSpec), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            widthSpec = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        } else if (mode != 1073741824) {
        }
        super.onMeasure(widthSpec, heightSpec);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(WindowInsetsCompat insets) {
        this.presenter.dispatchApplyWindowInsets(insets);
    }

    public void inflateMenu(int resId) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(resId, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(@LayoutRes int res) {
        return this.presenter.inflateHeaderView(res);
    }

    public void addHeaderView(@NonNull View view) {
        this.presenter.addHeaderView(view);
    }

    public void removeHeaderView(@NonNull View view) {
        this.presenter.removeHeaderView(view);
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int index) {
        return this.presenter.getHeaderView(index);
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public void setItemIconTintList(@Nullable ColorStateList tint) {
        this.presenter.setItemIconTintList(tint);
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public void setItemTextColor(@Nullable ColorStateList textColor) {
        this.presenter.setItemTextColor(textColor);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public void setItemBackgroundResource(@DrawableRes int resId) {
        setItemBackground(ContextCompat.getDrawable(getContext(), resId));
    }

    public void setItemBackground(@Nullable Drawable itemBackground) {
        this.presenter.setItemBackground(itemBackground);
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public void setItemHorizontalPadding(@Dimension int padding) {
        this.presenter.setItemHorizontalPadding(padding);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int paddingResource) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(paddingResource));
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public void setItemIconPadding(@Dimension int padding) {
        this.presenter.setItemIconPadding(padding);
    }

    public void setItemIconPaddingResource(int paddingResource) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(paddingResource));
    }

    public void setCheckedItem(@IdRes int id) {
        MenuItem item = this.menu.findItem(id);
        if (item != null) {
            this.presenter.setCheckedItem((MenuItemImpl) item);
        }
    }

    public void setCheckedItem(@NonNull MenuItem checkedItem) {
        MenuItem item = this.menu.findItem(checkedItem.getItemId());
        if (item != null) {
            this.presenter.setCheckedItem((MenuItemImpl) item);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public void setItemTextAppearance(@StyleRes int resId) {
        this.presenter.setItemTextAppearance(resId);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private ColorStateList createDefaultColorStateList(int baseColorThemeAttr) {
        TypedValue value = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(baseColorThemeAttr, value, true)) {
            return null;
        }
        ColorStateList baseColor = AppCompatResources.getColorStateList(getContext(), value.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0400R.attr.colorPrimary, value, true)) {
            return null;
        }
        int colorPrimary = value.data;
        int defaultColor = baseColor.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{baseColor.getColorForState(DISABLED_STATE_SET, defaultColor), colorPrimary, defaultColor});
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, (ClassLoader) null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        public Bundle menuState;

        public SavedState(Parcel in, ClassLoader loader) {
            super(in, loader);
            this.menuState = in.readBundle(loader);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(@NonNull Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeBundle(this.menuState);
        }
    }
}
