package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

public final class zac extends zaa {
    private WeakReference<ImageView> zanb;

    public zac(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.zanb = new WeakReference<>(imageView);
    }

    public zac(ImageView imageView, int i) {
        super((Uri) null, i);
        Asserts.checkNotNull(imageView);
        this.zanb = new WeakReference<>(imageView);
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zac)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ImageView imageView = (ImageView) this.zanb.get();
        ImageView imageView2 = (ImageView) ((zac) obj).zanb.get();
        if (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void zaa(Drawable drawable, boolean z, boolean z2, boolean z3) {
        boolean z4;
        ImageView imageView = (ImageView) this.zanb.get();
        if (imageView != null) {
            int i = 0;
            if (z2 || z3) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4 && (imageView instanceof zaj)) {
                int zach = zaj.zach();
                if (this.zamw != 0 && zach == this.zamw) {
                    return;
                }
            }
            boolean zaa = zaa(z, z2);
            Uri uri = null;
            if (zaa) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zae) {
                    drawable2 = ((zae) drawable2).zacf();
                }
                drawable = new zae(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zaj) {
                if (z3) {
                    uri = this.zamu.uri;
                }
                zaj.zaa(uri);
                if (z4) {
                    i = this.zamw;
                }
                zaj.zai(i);
            }
            if (zaa) {
                ((zae) drawable).startTransition(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            }
        }
    }
}
