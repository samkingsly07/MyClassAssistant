package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0400R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v7.widget.LinearLayoutCompat */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v7.widget.LinearLayoutCompat$DividerMode */
    public @interface DividerMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v7.widget.LinearLayoutCompat$OrientationMode */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, C0400R.styleable.LinearLayoutCompat, defStyleAttr, 0);
        int index = a.getInt(C0400R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (index >= 0) {
            setOrientation(index);
        }
        int index2 = a.getInt(C0400R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (index2 >= 0) {
            setGravity(index2);
        }
        boolean baselineAligned = a.getBoolean(C0400R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!baselineAligned) {
            setBaselineAligned(baselineAligned);
        }
        this.mWeightSum = a.getFloat(C0400R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = a.getInt(C0400R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = a.getBoolean(C0400R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.getDrawable(C0400R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = a.getInt(C0400R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = a.getDimensionPixelSize(C0400R.styleable.LinearLayoutCompat_dividerPadding, 0);
        a.recycle();
    }

    public void setShowDividers(int showDividers) {
        if (showDividers != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = showDividers;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable divider) {
        if (divider != this.mDivider) {
            this.mDivider = divider;
            boolean z = false;
            if (divider != null) {
                this.mDividerWidth = divider.getIntrinsicWidth();
                this.mDividerHeight = divider.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (divider == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int padding) {
        this.mDividerPadding = padding;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int bottom;
        int count = getVirtualChildCount();
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (child.getTop() - ((LayoutParams) child.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(count) != 0) {
            View child2 = getVirtualChildAt(count - 1);
            if (child2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = child2.getBottom() + ((LayoutParams) child2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int position;
        int position2;
        int count = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (isLayoutRtl) {
                    position2 = child.getRight() + lp.rightMargin;
                } else {
                    position2 = (child.getLeft() - lp.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, position2);
            }
        }
        if (hasDividerBeforeChildAt(count) != 0) {
            View child2 = getVirtualChildAt(count - 1);
            if (child2 != null) {
                LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
                if (isLayoutRtl) {
                    position = (child2.getLeft() - lp2.leftMargin) - this.mDividerWidth;
                } else {
                    position = child2.getRight() + lp2.rightMargin;
                }
            } else if (isLayoutRtl) {
                position = getPaddingLeft();
            } else {
                position = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, position);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int top) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, top, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + top);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int left) {
        this.mDivider.setBounds(left, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + left, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean baselineAligned) {
        this.mBaselineAligned = baselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        this.mUseLargestChild = enabled;
    }

    public int getBaseline() {
        int majorGravity;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View child = getChildAt(this.mBaselineAlignedChildIndex);
        int childBaseline = child.getBaseline();
        if (childBaseline != -1) {
            int childTop = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (majorGravity = this.mGravity & 112) != 48) {
                if (majorGravity == 16) {
                    childTop += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                } else if (majorGravity == 80) {
                    childTop = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                }
            }
            return ((LayoutParams) child.getLayoutParams()).topMargin + childTop + childBaseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int index) {
        return getChildAt(index);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float weightSum) {
        this.mWeightSum = Math.max(0.0f, weightSum);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mOrientation == 1) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int childIndex) {
        if (childIndex == 0) {
            if ((this.mShowDividers & 1) != 0) {
                return true;
            }
            return false;
        } else if (childIndex == getChildCount()) {
            if ((this.mShowDividers & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            for (int i = childIndex - 1; i >= 0; i--) {
                if (getChildAt(i).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03cc  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureVertical(int r58, int r59) {
        /*
            r57 = this;
            r7 = r57
            r8 = r58
            r9 = r59
            r10 = 0
            r7.mTotalLength = r10
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 1
            r5 = 0
            int r11 = r57.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r58)
            int r13 = android.view.View.MeasureSpec.getMode(r59)
            r6 = 0
            r14 = 0
            int r15 = r7.mBaselineAlignedChildIndex
            boolean r10 = r7.mUseLargestChild
            r17 = 0
            r18 = r6
            r6 = r2
            r2 = r0
            r0 = 0
            r56 = r4
            r4 = r3
            r3 = r17
            r17 = r56
        L_0x002f:
            r19 = r4
            r21 = 1
            r22 = 0
            if (r0 >= r11) goto L_0x01bb
            android.view.View r4 = r7.getVirtualChildAt(r0)
            if (r4 != 0) goto L_0x0054
            r25 = r1
            int r1 = r7.mTotalLength
            int r20 = r7.measureNullChild(r0)
            int r1 = r1 + r20
            r7.mTotalLength = r1
            r34 = r11
            r33 = r13
            r4 = r19
            r1 = r25
            goto L_0x01af
        L_0x0054:
            r25 = r1
            int r1 = r4.getVisibility()
            r26 = r2
            r2 = 8
            if (r1 != r2) goto L_0x0072
            int r1 = r7.getChildrenSkipCount(r4, r0)
            int r0 = r0 + r1
            r34 = r11
            r33 = r13
            r4 = r19
            r1 = r25
            r2 = r26
            goto L_0x01af
        L_0x0072:
            boolean r1 = r7.hasDividerBeforeChildAt(r0)
            if (r1 == 0) goto L_0x007f
            int r1 = r7.mTotalLength
            int r2 = r7.mDividerHeight
            int r1 = r1 + r2
            r7.mTotalLength = r1
        L_0x007f:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            r2 = r1
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r2 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r2
            float r1 = r2.weight
            float r23 = r5 + r1
            r5 = 1073741824(0x40000000, float:2.0)
            if (r13 != r5) goto L_0x00bd
            int r1 = r2.height
            if (r1 != 0) goto L_0x00bd
            float r1 = r2.weight
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 <= 0) goto L_0x00bd
            int r1 = r7.mTotalLength
            int r5 = r2.topMargin
            int r5 = r5 + r1
            r27 = r0
            int r0 = r2.bottomMargin
            int r5 = r5 + r0
            int r0 = java.lang.Math.max(r1, r5)
            r7.mTotalLength = r0
            r14 = 1
            r0 = r2
            r8 = r4
            r9 = r6
            r34 = r11
            r33 = r13
            r30 = r14
            r35 = r19
            r14 = r25
            r32 = r26
            r29 = r27
            goto L_0x012e
        L_0x00bd:
            r27 = r0
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r2.height
            if (r1 != 0) goto L_0x00cf
            float r1 = r2.weight
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cf
            r0 = 0
            r1 = -2
            r2.height = r1
        L_0x00cf:
            r5 = r0
            r24 = 0
            int r0 = (r23 > r22 ? 1 : (r23 == r22 ? 0 : -1))
            if (r0 != 0) goto L_0x00db
            int r0 = r7.mTotalLength
            r28 = r0
            goto L_0x00dd
        L_0x00db:
            r28 = 0
        L_0x00dd:
            r1 = r27
            r0 = r7
            r29 = r1
            r30 = r14
            r14 = r25
            r1 = r4
            r31 = r2
            r32 = r26
            r2 = r29
            r33 = r13
            r13 = r3
            r3 = r8
            r8 = r4
            r34 = r11
            r35 = r19
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r24
            r11 = r5
            r5 = r9
            r9 = r6
            r6 = r28
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == r0) goto L_0x010b
            r0 = r31
            r0.height = r11
            goto L_0x010d
        L_0x010b:
            r0 = r31
        L_0x010d:
            int r1 = r8.getMeasuredHeight()
            int r2 = r7.mTotalLength
            int r3 = r2 + r1
            int r4 = r0.topMargin
            int r3 = r3 + r4
            int r4 = r0.bottomMargin
            int r3 = r3 + r4
            int r4 = r7.getNextLocationOffset(r8)
            int r3 = r3 + r4
            int r3 = java.lang.Math.max(r2, r3)
            r7.mTotalLength = r3
            if (r10 == 0) goto L_0x012d
            int r3 = java.lang.Math.max(r1, r13)
            goto L_0x012e
        L_0x012d:
            r3 = r13
        L_0x012e:
            if (r15 < 0) goto L_0x013b
            r1 = r29
            int r2 = r1 + 1
            if (r15 != r2) goto L_0x013d
            int r2 = r7.mTotalLength
            r7.mBaselineChildTop = r2
            goto L_0x013d
        L_0x013b:
            r1 = r29
        L_0x013d:
            if (r1 >= r15) goto L_0x014d
            float r2 = r0.weight
            int r2 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x014d
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r4 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r2.<init>(r4)
            throw r2
        L_0x014d:
            r2 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            if (r12 == r4) goto L_0x015b
            int r4 = r0.width
            r6 = -1
            if (r4 != r6) goto L_0x015c
            r18 = 1
            r2 = 1
            goto L_0x015c
        L_0x015b:
            r6 = -1
        L_0x015c:
            int r4 = r0.leftMargin
            int r5 = r0.rightMargin
            int r4 = r4 + r5
            int r5 = r8.getMeasuredWidth()
            int r5 = r5 + r4
            r11 = r32
            int r11 = java.lang.Math.max(r11, r5)
            int r13 = r8.getMeasuredState()
            int r13 = android.view.View.combineMeasuredStates(r14, r13)
            if (r17 == 0) goto L_0x017d
            int r14 = r0.width
            if (r14 != r6) goto L_0x017d
            r6 = 1
            goto L_0x017e
        L_0x017d:
            r6 = 0
        L_0x017e:
            float r14 = r0.weight
            int r14 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r14 <= 0) goto L_0x0192
            if (r2 == 0) goto L_0x0188
            r14 = r4
            goto L_0x0189
        L_0x0188:
            r14 = r5
        L_0x0189:
            r36 = r6
            r6 = r35
            int r6 = java.lang.Math.max(r6, r14)
            goto L_0x019f
        L_0x0192:
            r36 = r6
            r6 = r35
            if (r2 == 0) goto L_0x019a
            r14 = r4
            goto L_0x019b
        L_0x019a:
            r14 = r5
        L_0x019b:
            int r9 = java.lang.Math.max(r9, r14)
        L_0x019f:
            int r14 = r7.getChildrenSkipCount(r8, r1)
            int r0 = r1 + r14
            r4 = r6
            r6 = r9
            r2 = r11
            r1 = r13
            r5 = r23
            r14 = r30
            r17 = r36
        L_0x01af:
            int r0 = r0 + 1
            r13 = r33
            r11 = r34
            r8 = r58
            r9 = r59
            goto L_0x002f
        L_0x01bb:
            r9 = r6
            r34 = r11
            r33 = r13
            r30 = r14
            r6 = r19
            r0 = -1
            r14 = r1
            r11 = r2
            r13 = r3
            int r1 = r7.mTotalLength
            if (r1 <= 0) goto L_0x01dc
            r1 = r34
            boolean r2 = r7.hasDividerBeforeChildAt(r1)
            if (r2 == 0) goto L_0x01de
            int r2 = r7.mTotalLength
            int r3 = r7.mDividerHeight
            int r2 = r2 + r3
            r7.mTotalLength = r2
            goto L_0x01de
        L_0x01dc:
            r1 = r34
        L_0x01de:
            if (r10 == 0) goto L_0x0235
            r2 = r33
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r3) goto L_0x01e8
            if (r2 != 0) goto L_0x0237
        L_0x01e8:
            r3 = 0
            r7.mTotalLength = r3
            r3 = 0
        L_0x01ec:
            if (r3 >= r1) goto L_0x0237
            android.view.View r4 = r7.getVirtualChildAt(r3)
            if (r4 != 0) goto L_0x01ff
            int r8 = r7.mTotalLength
            int r19 = r7.measureNullChild(r3)
            int r8 = r8 + r19
            r7.mTotalLength = r8
            goto L_0x020d
        L_0x01ff:
            int r8 = r4.getVisibility()
            r0 = 8
            if (r8 != r0) goto L_0x0210
            int r0 = r7.getChildrenSkipCount(r4, r3)
            int r3 = r3 + r0
        L_0x020d:
            r37 = r3
            goto L_0x0231
        L_0x0210:
            android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r0 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r0
            int r8 = r7.mTotalLength
            int r19 = r8 + r13
            r37 = r3
            int r3 = r0.topMargin
            int r19 = r19 + r3
            int r3 = r0.bottomMargin
            int r19 = r19 + r3
            int r3 = r7.getNextLocationOffset(r4)
            int r3 = r19 + r3
            int r3 = java.lang.Math.max(r8, r3)
            r7.mTotalLength = r3
        L_0x0231:
            int r3 = r37 + 1
            r0 = -1
            goto L_0x01ec
        L_0x0235:
            r2 = r33
        L_0x0237:
            int r0 = r7.mTotalLength
            int r3 = r57.getPaddingTop()
            int r4 = r57.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            r7.mTotalLength = r0
            int r0 = r7.mTotalLength
            int r3 = r57.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            r3 = r59
            r4 = 0
            int r8 = android.view.View.resolveSizeAndState(r0, r3, r4)
            r4 = 16777215(0xffffff, float:2.3509886E-38)
            r0 = r8 & r4
            int r4 = r7.mTotalLength
            int r4 = r0 - r4
            if (r30 != 0) goto L_0x02f4
            if (r4 == 0) goto L_0x0271
            int r19 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r19 <= 0) goto L_0x0271
            r38 = r0
            r39 = r4
            r40 = r5
            r41 = r6
            goto L_0x02fc
        L_0x0271:
            int r9 = java.lang.Math.max(r9, r6)
            if (r10 == 0) goto L_0x02de
            r38 = r0
            r0 = 1073741824(0x40000000, float:2.0)
            if (r2 == r0) goto L_0x02d5
            r16 = 0
        L_0x027f:
            r0 = r16
            if (r0 >= r1) goto L_0x02d5
            r39 = r4
            android.view.View r4 = r7.getVirtualChildAt(r0)
            if (r4 == 0) goto L_0x02c4
            r40 = r5
            int r5 = r4.getVisibility()
            r41 = r6
            r6 = 8
            if (r5 != r6) goto L_0x029b
            r44 = r9
            goto L_0x02ca
        L_0x029b:
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r5 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r5
            float r6 = r5.weight
            int r16 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r16 <= 0) goto L_0x02c1
            r42 = r5
            int r5 = r4.getMeasuredWidth()
            r43 = r6
            r6 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6)
            r44 = r9
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r6)
            r4.measure(r5, r9)
            goto L_0x02ca
        L_0x02c1:
            r44 = r9
            goto L_0x02ca
        L_0x02c4:
            r40 = r5
            r41 = r6
            r44 = r9
        L_0x02ca:
            int r16 = r0 + 1
            r4 = r39
            r5 = r40
            r6 = r41
            r9 = r44
            goto L_0x027f
        L_0x02d5:
            r39 = r4
            r40 = r5
            r41 = r6
            r44 = r9
            goto L_0x02e8
        L_0x02de:
            r38 = r0
            r39 = r4
            r40 = r5
            r41 = r6
            r44 = r9
        L_0x02e8:
            r51 = r2
            r45 = r10
            r46 = r13
            r47 = r15
            r13 = r58
            goto L_0x0431
        L_0x02f4:
            r38 = r0
            r39 = r4
            r40 = r5
            r41 = r6
        L_0x02fc:
            float r0 = r7.mWeightSum
            int r0 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r0 <= 0) goto L_0x0305
            float r5 = r7.mWeightSum
            goto L_0x0307
        L_0x0305:
            r5 = r40
        L_0x0307:
            r0 = r5
            r4 = 0
            r7.mTotalLength = r4
            r6 = r39
            r0 = 0
        L_0x030e:
            if (r0 >= r1) goto L_0x0414
            android.view.View r4 = r7.getVirtualChildAt(r0)
            r45 = r10
            int r10 = r4.getVisibility()
            r46 = r13
            r13 = 8
            if (r10 != r13) goto L_0x0329
            r51 = r2
            r47 = r15
            r13 = r58
            goto L_0x0407
        L_0x0329:
            android.view.ViewGroup$LayoutParams r10 = r4.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r10 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r10
            float r13 = r10.weight
            int r16 = (r13 > r22 ? 1 : (r13 == r22 ? 0 : -1))
            if (r16 <= 0) goto L_0x03a2
            r47 = r15
            float r15 = (float) r6
            float r15 = r15 * r13
            float r15 = r15 / r5
            int r15 = (int) r15
            float r5 = r5 - r13
            int r6 = r6 - r15
            int r16 = r57.getPaddingLeft()
            int r19 = r57.getPaddingRight()
            int r16 = r16 + r19
            r48 = r5
            int r5 = r10.leftMargin
            int r16 = r16 + r5
            int r5 = r10.rightMargin
            int r5 = r16 + r5
            r49 = r6
            int r6 = r10.width
            r50 = r13
            r13 = r58
            int r5 = getChildMeasureSpec(r13, r5, r6)
            int r6 = r10.height
            if (r6 != 0) goto L_0x037d
            r6 = 1073741824(0x40000000, float:2.0)
            if (r2 == r6) goto L_0x036a
            r51 = r2
            goto L_0x037f
        L_0x036a:
            if (r15 <= 0) goto L_0x036e
            r6 = r15
            goto L_0x036f
        L_0x036e:
            r6 = 0
        L_0x036f:
            r51 = r2
            r2 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r2)
            r4.measure(r5, r6)
            r52 = r15
            goto L_0x0394
        L_0x037d:
            r51 = r2
        L_0x037f:
            int r2 = r4.getMeasuredHeight()
            int r2 = r2 + r15
            if (r2 >= 0) goto L_0x0387
            r2 = 0
        L_0x0387:
            r52 = r15
            r6 = 1073741824(0x40000000, float:2.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r6)
            r4.measure(r5, r15)
        L_0x0394:
            int r2 = r4.getMeasuredState()
            r2 = r2 & -256(0xffffffffffffff00, float:NaN)
            int r14 = android.view.View.combineMeasuredStates(r14, r2)
            r5 = r48
            goto L_0x03ac
        L_0x03a2:
            r51 = r2
            r50 = r13
            r47 = r15
            r13 = r58
            r49 = r6
        L_0x03ac:
            int r2 = r10.leftMargin
            int r6 = r10.rightMargin
            int r2 = r2 + r6
            int r6 = r4.getMeasuredWidth()
            int r6 = r6 + r2
            int r11 = java.lang.Math.max(r11, r6)
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 == r15) goto L_0x03c7
            int r15 = r10.width
            r53 = r2
            r2 = -1
            if (r15 != r2) goto L_0x03c9
            r2 = 1
            goto L_0x03ca
        L_0x03c7:
            r53 = r2
        L_0x03c9:
            r2 = 0
        L_0x03ca:
            if (r2 == 0) goto L_0x03cf
            r15 = r53
            goto L_0x03d0
        L_0x03cf:
            r15 = r6
        L_0x03d0:
            int r9 = java.lang.Math.max(r9, r15)
            if (r17 == 0) goto L_0x03df
            int r15 = r10.width
            r54 = r2
            r2 = -1
            if (r15 != r2) goto L_0x03e2
            r15 = 1
            goto L_0x03e3
        L_0x03df:
            r54 = r2
            r2 = -1
        L_0x03e2:
            r15 = 0
        L_0x03e3:
            int r2 = r7.mTotalLength
            int r16 = r4.getMeasuredHeight()
            int r16 = r2 + r16
            r55 = r5
            int r5 = r10.topMargin
            int r16 = r16 + r5
            int r5 = r10.bottomMargin
            int r16 = r16 + r5
            int r5 = r7.getNextLocationOffset(r4)
            int r5 = r16 + r5
            int r5 = java.lang.Math.max(r2, r5)
            r7.mTotalLength = r5
            r17 = r15
            r6 = r49
            r5 = r55
        L_0x0407:
            int r0 = r0 + 1
            r10 = r45
            r13 = r46
            r15 = r47
            r2 = r51
            r4 = 0
            goto L_0x030e
        L_0x0414:
            r51 = r2
            r45 = r10
            r46 = r13
            r47 = r15
            r13 = r58
            int r0 = r7.mTotalLength
            int r2 = r57.getPaddingTop()
            int r4 = r57.getPaddingBottom()
            int r2 = r2 + r4
            int r0 = r0 + r2
            r7.mTotalLength = r0
            r39 = r6
            r44 = r9
        L_0x0431:
            if (r17 != 0) goto L_0x0439
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x0439
            r11 = r44
        L_0x0439:
            int r0 = r57.getPaddingLeft()
            int r2 = r57.getPaddingRight()
            int r0 = r0 + r2
            int r11 = r11 + r0
            int r0 = r57.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r11, r0)
            int r2 = android.view.View.resolveSizeAndState(r0, r13, r14)
            r7.setMeasuredDimension(r2, r8)
            if (r18 == 0) goto L_0x0457
            r7.forceUniformWidth(r1, r3)
        L_0x0457:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.LinearLayoutCompat.measureVertical(int, int):void");
    }

    private void forceUniformWidth(int count, int heightMeasureSpec) {
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.width == -1) {
                    int oldHeight = lp.height;
                    lp.height = child.getMeasuredHeight();
                    measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                    lp.height = oldHeight;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x05cf  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0214  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureHorizontal(int r64, int r65) {
        /*
            r63 = this;
            r7 = r63
            r8 = r64
            r9 = r65
            r10 = 0
            r7.mTotalLength = r10
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 1
            r5 = 0
            int r11 = r63.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r64)
            int r13 = android.view.View.MeasureSpec.getMode(r65)
            r6 = 0
            r14 = 0
            int[] r15 = r7.mMaxAscent
            if (r15 == 0) goto L_0x0025
            int[] r15 = r7.mMaxDescent
            if (r15 != 0) goto L_0x002e
        L_0x0025:
            r15 = 4
            int[] r10 = new int[r15]
            r7.mMaxAscent = r10
            int[] r10 = new int[r15]
            r7.mMaxDescent = r10
        L_0x002e:
            int[] r10 = r7.mMaxAscent
            int[] r15 = r7.mMaxDescent
            r17 = 3
            r18 = r6
            r6 = -1
            r10[r17] = r6
            r19 = 2
            r10[r19] = r6
            r20 = 1
            r10[r20] = r6
            r16 = 0
            r10[r16] = r6
            r15[r17] = r6
            r15[r19] = r6
            r15[r20] = r6
            r15[r16] = r6
            boolean r6 = r7.mBaselineAligned
            r22 = r14
            boolean r14 = r7.mUseLargestChild
            r23 = r15
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 != r15) goto L_0x005c
            r24 = 1
            goto L_0x005e
        L_0x005c:
            r24 = 0
        L_0x005e:
            r25 = 0
            r26 = r1
            r1 = r25
            r25 = r18
            r18 = r4
            r4 = r0
            r0 = 0
            r62 = r3
            r3 = r2
            r2 = r62
        L_0x006f:
            r28 = 0
            if (r0 >= r11) goto L_0x0241
            android.view.View r15 = r7.getVirtualChildAt(r0)
            if (r15 != 0) goto L_0x008c
            r30 = r1
            int r1 = r7.mTotalLength
            int r27 = r7.measureNullChild(r0)
            int r1 = r1 + r27
            r7.mTotalLength = r1
            r21 = r6
            r1 = r30
            goto L_0x0235
        L_0x008c:
            r30 = r1
            int r1 = r15.getVisibility()
            r31 = r2
            r2 = 8
            if (r1 != r2) goto L_0x00a6
            int r1 = r7.getChildrenSkipCount(r15, r0)
            int r0 = r0 + r1
            r21 = r6
            r1 = r30
            r2 = r31
            goto L_0x0235
        L_0x00a6:
            boolean r1 = r7.hasDividerBeforeChildAt(r0)
            if (r1 == 0) goto L_0x00b3
            int r1 = r7.mTotalLength
            int r2 = r7.mDividerWidth
            int r1 = r1 + r2
            r7.mTotalLength = r1
        L_0x00b3:
            android.view.ViewGroup$LayoutParams r1 = r15.getLayoutParams()
            r2 = r1
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r2 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r2
            float r1 = r2.weight
            float r29 = r5 + r1
            r1 = 1073741824(0x40000000, float:2.0)
            if (r12 != r1) goto L_0x0117
            int r1 = r2.width
            if (r1 != 0) goto L_0x0117
            float r1 = r2.weight
            int r1 = (r1 > r28 ? 1 : (r1 == r28 ? 0 : -1))
            if (r1 <= 0) goto L_0x0117
            if (r24 == 0) goto L_0x00dc
            int r1 = r7.mTotalLength
            int r5 = r2.leftMargin
            r32 = r0
            int r0 = r2.rightMargin
            int r5 = r5 + r0
            int r1 = r1 + r5
            r7.mTotalLength = r1
            goto L_0x00ec
        L_0x00dc:
            r32 = r0
            int r0 = r7.mTotalLength
            int r1 = r2.leftMargin
            int r1 = r1 + r0
            int r5 = r2.rightMargin
            int r1 = r1 + r5
            int r1 = java.lang.Math.max(r0, r1)
            r7.mTotalLength = r1
        L_0x00ec:
            if (r6 == 0) goto L_0x0107
            r0 = 0
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r15.measure(r1, r1)
            r0 = r2
            r39 = r3
            r40 = r4
            r21 = r6
            r2 = r30
            r38 = r31
            r35 = r32
            r9 = -1
            goto L_0x019a
        L_0x0107:
            r22 = 1
            r0 = r2
            r39 = r3
            r40 = r4
            r21 = r6
            r38 = r31
            r35 = r32
            r9 = -1
            goto L_0x019c
        L_0x0117:
            r32 = r0
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r2.width
            if (r1 != 0) goto L_0x0129
            float r1 = r2.weight
            int r1 = (r1 > r28 ? 1 : (r1 == r28 ? 0 : -1))
            if (r1 <= 0) goto L_0x0129
            r0 = 0
            r1 = -2
            r2.width = r1
        L_0x0129:
            r5 = r0
            int r0 = (r29 > r28 ? 1 : (r29 == r28 ? 0 : -1))
            if (r0 != 0) goto L_0x0133
            int r0 = r7.mTotalLength
            r33 = r0
            goto L_0x0135
        L_0x0133:
            r33 = 0
        L_0x0135:
            r34 = 0
            r1 = r32
            r0 = r7
            r35 = r1
            r36 = r30
            r1 = r15
            r37 = r2
            r38 = r31
            r2 = r35
            r39 = r3
            r3 = r8
            r40 = r4
            r4 = r33
            r8 = r5
            r5 = r9
            r21 = r6
            r9 = -1
            r6 = r34
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r8 == r0) goto L_0x015f
            r0 = r37
            r0.width = r8
            goto L_0x0161
        L_0x015f:
            r0 = r37
        L_0x0161:
            int r1 = r15.getMeasuredWidth()
            if (r24 == 0) goto L_0x0178
            int r2 = r7.mTotalLength
            int r3 = r0.leftMargin
            int r3 = r3 + r1
            int r4 = r0.rightMargin
            int r3 = r3 + r4
            int r4 = r7.getNextLocationOffset(r15)
            int r3 = r3 + r4
            int r2 = r2 + r3
            r7.mTotalLength = r2
            goto L_0x018d
        L_0x0178:
            int r2 = r7.mTotalLength
            int r3 = r2 + r1
            int r4 = r0.leftMargin
            int r3 = r3 + r4
            int r4 = r0.rightMargin
            int r3 = r3 + r4
            int r4 = r7.getNextLocationOffset(r15)
            int r3 = r3 + r4
            int r3 = java.lang.Math.max(r2, r3)
            r7.mTotalLength = r3
        L_0x018d:
            if (r14 == 0) goto L_0x0198
            r2 = r36
            int r1 = java.lang.Math.max(r1, r2)
            r30 = r1
            goto L_0x019c
        L_0x0198:
            r2 = r36
        L_0x019a:
            r30 = r2
        L_0x019c:
            r1 = 0
            r2 = 1073741824(0x40000000, float:2.0)
            if (r13 == r2) goto L_0x01a8
            int r2 = r0.height
            if (r2 != r9) goto L_0x01a8
            r25 = 1
            r1 = 1
        L_0x01a8:
            int r2 = r0.topMargin
            int r3 = r0.bottomMargin
            int r2 = r2 + r3
            int r3 = r15.getMeasuredHeight()
            int r3 = r3 + r2
            int r4 = r15.getMeasuredState()
            r6 = r26
            int r4 = android.view.View.combineMeasuredStates(r6, r4)
            if (r21 == 0) goto L_0x01ec
            int r5 = r15.getBaseline()
            if (r5 == r9) goto L_0x01ec
            int r6 = r0.gravity
            if (r6 >= 0) goto L_0x01cb
            int r6 = r7.mGravity
            goto L_0x01cd
        L_0x01cb:
            int r6 = r0.gravity
        L_0x01cd:
            r6 = r6 & 112(0x70, float:1.57E-43)
            int r8 = r6 >> 4
            r26 = -2
            r8 = r8 & -2
            int r8 = r8 >> 1
            r9 = r10[r8]
            int r9 = java.lang.Math.max(r9, r5)
            r10[r8] = r9
            r9 = r23[r8]
            r41 = r2
            int r2 = r3 - r5
            int r2 = java.lang.Math.max(r9, r2)
            r23[r8] = r2
            goto L_0x01ee
        L_0x01ec:
            r41 = r2
        L_0x01ee:
            r8 = r40
            int r2 = java.lang.Math.max(r8, r3)
            if (r18 == 0) goto L_0x01fd
            int r5 = r0.height
            r6 = -1
            if (r5 != r6) goto L_0x01fd
            r5 = 1
            goto L_0x01fe
        L_0x01fd:
            r5 = 0
        L_0x01fe:
            float r6 = r0.weight
            int r6 = (r6 > r28 ? 1 : (r6 == r28 ? 0 : -1))
            if (r6 <= 0) goto L_0x0214
            if (r1 == 0) goto L_0x0209
            r6 = r41
            goto L_0x020a
        L_0x0209:
            r6 = r3
        L_0x020a:
            r9 = r38
            int r6 = java.lang.Math.max(r9, r6)
            r9 = r6
            r6 = r39
            goto L_0x0222
        L_0x0214:
            r9 = r38
            if (r1 == 0) goto L_0x021b
            r6 = r41
            goto L_0x021c
        L_0x021b:
            r6 = r3
        L_0x021c:
            r8 = r39
            int r6 = java.lang.Math.max(r8, r6)
        L_0x0222:
            r8 = r35
            int r18 = r7.getChildrenSkipCount(r15, r8)
            int r0 = r8 + r18
            r26 = r4
            r18 = r5
            r3 = r6
            r5 = r29
            r1 = r30
            r4 = r2
            r2 = r9
        L_0x0235:
            int r0 = r0 + 1
            r6 = r21
            r8 = r64
            r9 = r65
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x006f
        L_0x0241:
            r9 = r2
            r8 = r4
            r21 = r6
            r6 = r26
            r2 = r1
            int r0 = r7.mTotalLength
            if (r0 <= 0) goto L_0x0259
            boolean r0 = r7.hasDividerBeforeChildAt(r11)
            if (r0 == 0) goto L_0x0259
            int r0 = r7.mTotalLength
            int r1 = r7.mDividerWidth
            int r0 = r0 + r1
            r7.mTotalLength = r0
        L_0x0259:
            r0 = r10[r20]
            r1 = -1
            if (r0 != r1) goto L_0x0270
            r0 = 0
            r4 = r10[r0]
            if (r4 != r1) goto L_0x0270
            r0 = r10[r19]
            if (r0 != r1) goto L_0x0270
            r0 = r10[r17]
            if (r0 == r1) goto L_0x026c
            goto L_0x0270
        L_0x026c:
            r42 = r6
            r4 = r8
            goto L_0x02a2
        L_0x0270:
            r0 = r10[r17]
            r1 = 0
            r4 = r10[r1]
            r15 = r10[r20]
            r1 = r10[r19]
            int r1 = java.lang.Math.max(r15, r1)
            int r1 = java.lang.Math.max(r4, r1)
            int r0 = java.lang.Math.max(r0, r1)
            r1 = r23[r17]
            r4 = 0
            r15 = r23[r4]
            r4 = r23[r20]
            r42 = r6
            r6 = r23[r19]
            int r4 = java.lang.Math.max(r4, r6)
            int r4 = java.lang.Math.max(r15, r4)
            int r1 = java.lang.Math.max(r1, r4)
            int r4 = r0 + r1
            int r4 = java.lang.Math.max(r8, r4)
        L_0x02a2:
            if (r14 == 0) goto L_0x0309
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r0) goto L_0x02aa
            if (r12 != 0) goto L_0x0309
        L_0x02aa:
            r0 = 0
            r7.mTotalLength = r0
            r0 = 0
        L_0x02ae:
            if (r0 >= r11) goto L_0x0309
            android.view.View r1 = r7.getVirtualChildAt(r0)
            if (r1 != 0) goto L_0x02c3
            int r6 = r7.mTotalLength
            int r8 = r7.measureNullChild(r0)
            int r6 = r6 + r8
            r7.mTotalLength = r6
            r43 = r0
            goto L_0x0304
        L_0x02c3:
            int r6 = r1.getVisibility()
            r8 = 8
            if (r6 != r8) goto L_0x02d1
            int r6 = r7.getChildrenSkipCount(r1, r0)
            int r0 = r0 + r6
            goto L_0x0306
        L_0x02d1:
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r6 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r6
            if (r24 == 0) goto L_0x02ed
            int r8 = r7.mTotalLength
            int r15 = r6.leftMargin
            int r15 = r15 + r2
            r43 = r0
            int r0 = r6.rightMargin
            int r15 = r15 + r0
            int r0 = r7.getNextLocationOffset(r1)
            int r15 = r15 + r0
            int r8 = r8 + r15
            r7.mTotalLength = r8
            goto L_0x0304
        L_0x02ed:
            r43 = r0
            int r0 = r7.mTotalLength
            int r8 = r0 + r2
            int r15 = r6.leftMargin
            int r8 = r8 + r15
            int r15 = r6.rightMargin
            int r8 = r8 + r15
            int r15 = r7.getNextLocationOffset(r1)
            int r8 = r8 + r15
            int r8 = java.lang.Math.max(r0, r8)
            r7.mTotalLength = r8
        L_0x0304:
            r0 = r43
        L_0x0306:
            int r0 = r0 + 1
            goto L_0x02ae
        L_0x0309:
            int r0 = r7.mTotalLength
            int r1 = r63.getPaddingLeft()
            int r6 = r63.getPaddingRight()
            int r1 = r1 + r6
            int r0 = r0 + r1
            r7.mTotalLength = r0
            int r0 = r7.mTotalLength
            int r1 = r63.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r1)
            r1 = r64
            r6 = 0
            int r8 = android.view.View.resolveSizeAndState(r0, r1, r6)
            r6 = 16777215(0xffffff, float:2.3509886E-38)
            r0 = r8 & r6
            int r6 = r7.mTotalLength
            int r6 = r0 - r6
            if (r22 != 0) goto L_0x03bb
            if (r6 == 0) goto L_0x0341
            int r26 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r26 <= 0) goto L_0x0341
            r44 = r0
            r49 = r2
            r46 = r4
            goto L_0x03c1
        L_0x0341:
            int r3 = java.lang.Math.max(r3, r9)
            if (r14 == 0) goto L_0x03a3
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 == r15) goto L_0x03a3
            r16 = 0
        L_0x034d:
            r15 = r16
            if (r15 >= r11) goto L_0x03a3
            r44 = r0
            android.view.View r0 = r7.getVirtualChildAt(r15)
            if (r0 == 0) goto L_0x0392
            r45 = r3
            int r3 = r0.getVisibility()
            r46 = r4
            r4 = 8
            if (r3 != r4) goto L_0x0369
            r49 = r2
            goto L_0x0398
        L_0x0369:
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r3 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r3
            float r4 = r3.weight
            int r16 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1))
            if (r16 <= 0) goto L_0x038f
            r47 = r3
            r48 = r4
            r3 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r3)
            r49 = r2
            int r2 = r0.getMeasuredHeight()
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r3)
            r0.measure(r4, r2)
            goto L_0x0398
        L_0x038f:
            r49 = r2
            goto L_0x0398
        L_0x0392:
            r49 = r2
            r45 = r3
            r46 = r4
        L_0x0398:
            int r16 = r15 + 1
            r0 = r44
            r3 = r45
            r4 = r46
            r2 = r49
            goto L_0x034d
        L_0x03a3:
            r44 = r0
            r49 = r2
            r45 = r3
            r46 = r4
            r50 = r5
            r51 = r9
            r56 = r11
            r52 = r14
            r2 = r45
            r15 = r46
            r14 = r65
            goto L_0x059e
        L_0x03bb:
            r44 = r0
            r49 = r2
            r46 = r4
        L_0x03c1:
            float r0 = r7.mWeightSum
            int r0 = (r0 > r28 ? 1 : (r0 == r28 ? 0 : -1))
            if (r0 <= 0) goto L_0x03ca
            float r0 = r7.mWeightSum
            goto L_0x03cb
        L_0x03ca:
            r0 = r5
        L_0x03cb:
            r2 = -1
            r10[r17] = r2
            r10[r19] = r2
            r10[r20] = r2
            r4 = 0
            r10[r4] = r2
            r23[r17] = r2
            r23[r19] = r2
            r23[r20] = r2
            r23[r4] = r2
            r15 = -1
            r7.mTotalLength = r4
            r2 = r3
            r4 = r42
            r3 = r0
            r0 = 0
        L_0x03e5:
            if (r0 >= r11) goto L_0x0542
            r50 = r5
            android.view.View r5 = r7.getVirtualChildAt(r0)
            if (r5 == 0) goto L_0x052a
            r51 = r9
            int r9 = r5.getVisibility()
            r52 = r14
            r14 = 8
            if (r9 != r14) goto L_0x0404
            r56 = r11
            r14 = r65
            r26 = -2
            goto L_0x0534
        L_0x0404:
            android.view.ViewGroup$LayoutParams r9 = r5.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r9 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r9
            float r14 = r9.weight
            int r26 = (r14 > r28 ? 1 : (r14 == r28 ? 0 : -1))
            if (r26 <= 0) goto L_0x0476
            float r1 = (float) r6
            float r1 = r1 * r14
            float r1 = r1 / r3
            int r1 = (int) r1
            float r3 = r3 - r14
            int r6 = r6 - r1
            int r26 = r63.getPaddingTop()
            int r27 = r63.getPaddingBottom()
            int r26 = r26 + r27
            r53 = r3
            int r3 = r9.topMargin
            int r26 = r26 + r3
            int r3 = r9.bottomMargin
            int r3 = r26 + r3
            r54 = r6
            int r6 = r9.height
            r56 = r11
            r55 = r14
            r11 = -1
            r14 = r65
            int r3 = getChildMeasureSpec(r14, r3, r6)
            int r6 = r9.width
            if (r6 != 0) goto L_0x0454
            r6 = 1073741824(0x40000000, float:2.0)
            if (r12 == r6) goto L_0x0445
            goto L_0x0454
        L_0x0445:
            if (r1 <= 0) goto L_0x0449
            r11 = r1
            goto L_0x044a
        L_0x0449:
            r11 = 0
        L_0x044a:
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r6)
            r5.measure(r11, r3)
            r57 = r1
            goto L_0x0469
        L_0x0454:
            int r6 = r5.getMeasuredWidth()
            int r6 = r6 + r1
            if (r6 >= 0) goto L_0x045c
            r6 = 0
        L_0x045c:
            r57 = r1
            r11 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r11)
            r5.measure(r1, r3)
        L_0x0469:
            int r1 = r5.getMeasuredState()
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r6
            int r4 = android.view.View.combineMeasuredStates(r4, r1)
            goto L_0x0480
        L_0x0476:
            r56 = r11
            r55 = r14
            r14 = r65
            r53 = r3
            r54 = r6
        L_0x0480:
            if (r24 == 0) goto L_0x0497
            int r1 = r7.mTotalLength
            int r3 = r5.getMeasuredWidth()
            int r6 = r9.leftMargin
            int r3 = r3 + r6
            int r6 = r9.rightMargin
            int r3 = r3 + r6
            int r6 = r7.getNextLocationOffset(r5)
            int r3 = r3 + r6
            int r1 = r1 + r3
            r7.mTotalLength = r1
            goto L_0x04af
        L_0x0497:
            int r1 = r7.mTotalLength
            int r3 = r5.getMeasuredWidth()
            int r3 = r3 + r1
            int r6 = r9.leftMargin
            int r3 = r3 + r6
            int r6 = r9.rightMargin
            int r3 = r3 + r6
            int r6 = r7.getNextLocationOffset(r5)
            int r3 = r3 + r6
            int r3 = java.lang.Math.max(r1, r3)
            r7.mTotalLength = r3
        L_0x04af:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r13 == r1) goto L_0x04ba
            int r1 = r9.height
            r3 = -1
            if (r1 != r3) goto L_0x04ba
            r1 = 1
            goto L_0x04bb
        L_0x04ba:
            r1 = 0
        L_0x04bb:
            int r3 = r9.topMargin
            int r6 = r9.bottomMargin
            int r3 = r3 + r6
            int r6 = r5.getMeasuredHeight()
            int r6 = r6 + r3
            int r11 = java.lang.Math.max(r15, r6)
            if (r1 == 0) goto L_0x04cd
            r15 = r3
            goto L_0x04ce
        L_0x04cd:
            r15 = r6
        L_0x04ce:
            int r2 = java.lang.Math.max(r2, r15)
            if (r18 == 0) goto L_0x04dd
            int r15 = r9.height
            r58 = r1
            r1 = -1
            if (r15 != r1) goto L_0x04df
            r1 = 1
            goto L_0x04e0
        L_0x04dd:
            r58 = r1
        L_0x04df:
            r1 = 0
        L_0x04e0:
            if (r21 == 0) goto L_0x051a
            int r15 = r5.getBaseline()
            r59 = r1
            r1 = -1
            if (r15 == r1) goto L_0x0515
            int r1 = r9.gravity
            if (r1 >= 0) goto L_0x04f2
            int r1 = r7.mGravity
            goto L_0x04f4
        L_0x04f2:
            int r1 = r9.gravity
        L_0x04f4:
            r1 = r1 & 112(0x70, float:1.57E-43)
            int r18 = r1 >> 4
            r26 = -2
            r18 = r18 & -2
            int r18 = r18 >> 1
            r60 = r1
            r1 = r10[r18]
            int r1 = java.lang.Math.max(r1, r15)
            r10[r18] = r1
            r1 = r23[r18]
            r61 = r2
            int r2 = r6 - r15
            int r1 = java.lang.Math.max(r1, r2)
            r23[r18] = r1
            goto L_0x0520
        L_0x0515:
            r61 = r2
            r26 = -2
            goto L_0x0520
        L_0x051a:
            r59 = r1
            r61 = r2
            r26 = -2
        L_0x0520:
            r15 = r11
            r3 = r53
            r6 = r54
            r18 = r59
            r2 = r61
            goto L_0x0534
        L_0x052a:
            r51 = r9
            r56 = r11
            r52 = r14
            r14 = r65
            r26 = -2
        L_0x0534:
            int r0 = r0 + 1
            r5 = r50
            r9 = r51
            r14 = r52
            r11 = r56
            r1 = r64
            goto L_0x03e5
        L_0x0542:
            r50 = r5
            r51 = r9
            r56 = r11
            r52 = r14
            r14 = r65
            int r0 = r7.mTotalLength
            int r1 = r63.getPaddingLeft()
            int r5 = r63.getPaddingRight()
            int r1 = r1 + r5
            int r0 = r0 + r1
            r7.mTotalLength = r0
            r0 = r10[r20]
            r1 = -1
            if (r0 != r1) goto L_0x056c
            r0 = 0
            r5 = r10[r0]
            if (r5 != r1) goto L_0x056c
            r0 = r10[r19]
            if (r0 != r1) goto L_0x056c
            r0 = r10[r17]
            if (r0 == r1) goto L_0x059c
        L_0x056c:
            r0 = r10[r17]
            r1 = 0
            r5 = r10[r1]
            r9 = r10[r20]
            r11 = r10[r19]
            int r9 = java.lang.Math.max(r9, r11)
            int r5 = java.lang.Math.max(r5, r9)
            int r0 = java.lang.Math.max(r0, r5)
            r5 = r23[r17]
            r1 = r23[r1]
            r9 = r23[r20]
            r11 = r23[r19]
            int r9 = java.lang.Math.max(r9, r11)
            int r1 = java.lang.Math.max(r1, r9)
            int r1 = java.lang.Math.max(r5, r1)
            int r5 = r0 + r1
            int r0 = java.lang.Math.max(r15, r5)
            r15 = r0
        L_0x059c:
            r42 = r4
        L_0x059e:
            if (r18 != 0) goto L_0x05a5
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 == r0) goto L_0x05a5
            r15 = r2
        L_0x05a5:
            int r0 = r63.getPaddingTop()
            int r1 = r63.getPaddingBottom()
            int r0 = r0 + r1
            int r15 = r15 + r0
            int r0 = r63.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r15, r0)
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r42 & r1
            r1 = r1 | r8
            int r3 = r42 << 16
            int r3 = android.view.View.resolveSizeAndState(r0, r14, r3)
            r7.setMeasuredDimension(r1, r3)
            if (r25 == 0) goto L_0x05cf
            r3 = r56
            r1 = r64
            r7.forceUniformHeight(r3, r1)
            goto L_0x05d3
        L_0x05cf:
            r3 = r56
            r1 = r64
        L_0x05d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.LinearLayoutCompat.measureHorizontal(int, int):void");
    }

    private void forceUniformHeight(int count, int widthMeasureSpec) {
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.height == -1) {
                    int oldWidth = lp.width;
                    lp.width = child.getMeasuredWidth();
                    measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                    lp.width = oldWidth;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View child, int index) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int childIndex) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View child, int childIndex, int widthMeasureSpec, int totalWidth, int heightMeasureSpec, int totalHeight) {
        measureChildWithMargins(child, widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View child) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View child) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.mOrientation == 1) {
            layoutVertical(l, t, r, b);
        } else {
            layoutHorizontal(l, t, r, b);
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int left, int top, int right, int bottom) {
        int childTop;
        int paddingLeft;
        int majorGravity;
        int childLeft;
        int paddingLeft2 = getPaddingLeft();
        int width = right - left;
        int childRight = width - getPaddingRight();
        int childSpace = (width - paddingLeft2) - getPaddingRight();
        int count = getVirtualChildCount();
        int majorGravity2 = this.mGravity & 112;
        int minorGravity = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (majorGravity2 == 16) {
            childTop = getPaddingTop() + (((bottom - top) - this.mTotalLength) / 2);
        } else if (majorGravity2 != 80) {
            childTop = getPaddingTop();
        } else {
            childTop = ((getPaddingTop() + bottom) - top) - this.mTotalLength;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < count) {
                View child = getVirtualChildAt(i2);
                if (child == null) {
                    childTop += measureNullChild(i2);
                    majorGravity = majorGravity2;
                    paddingLeft = paddingLeft2;
                } else if (child.getVisibility() != 8) {
                    int childWidth = child.getMeasuredWidth();
                    int childHeight = child.getMeasuredHeight();
                    LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    int gravity = lp.gravity;
                    if (gravity < 0) {
                        gravity = minorGravity;
                    }
                    int layoutDirection = ViewCompat.getLayoutDirection(this);
                    int gravity2 = gravity;
                    int gravity3 = GravityCompat.getAbsoluteGravity(gravity, layoutDirection) & 7;
                    majorGravity = majorGravity2;
                    if (gravity3 != 1) {
                        childLeft = gravity3 != 5 ? lp.leftMargin + paddingLeft2 : (childRight - childWidth) - lp.rightMargin;
                    } else {
                        childLeft = ((((childSpace - childWidth) / 2) + paddingLeft2) + lp.leftMargin) - lp.rightMargin;
                    }
                    int i3 = gravity2;
                    if (hasDividerBeforeChildAt(i2)) {
                        childTop += this.mDividerHeight;
                    }
                    int childTop2 = childTop + lp.topMargin;
                    int i4 = layoutDirection;
                    LayoutParams lp2 = lp;
                    View child2 = child;
                    paddingLeft = paddingLeft2;
                    int paddingLeft3 = i2;
                    setChildFrame(child, childLeft, childTop2 + getLocationOffset(child), childWidth, childHeight);
                    int childTop3 = childTop2 + childHeight + lp2.bottomMargin + getNextLocationOffset(child2);
                    i2 = paddingLeft3 + getChildrenSkipCount(child2, paddingLeft3);
                    childTop = childTop3;
                } else {
                    majorGravity = majorGravity2;
                    paddingLeft = paddingLeft2;
                    int paddingLeft4 = i2;
                }
                i = i2 + 1;
                majorGravity2 = majorGravity;
                paddingLeft2 = paddingLeft;
            } else {
                int i5 = paddingLeft2;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutHorizontal(int r32, int r33, int r34, int r35) {
        /*
            r31 = this;
            r6 = r31
            boolean r9 = android.support.p003v7.widget.ViewUtils.isLayoutRtl(r31)
            int r10 = r31.getPaddingTop()
            int r13 = r35 - r33
            int r0 = r31.getPaddingBottom()
            int r14 = r13 - r0
            int r0 = r13 - r10
            int r1 = r31.getPaddingBottom()
            int r15 = r0 - r1
            int r5 = r31.getVirtualChildCount()
            int r0 = r6.mGravity
            r1 = 8388615(0x800007, float:1.1754953E-38)
            r4 = r0 & r1
            int r0 = r6.mGravity
            r16 = r0 & 112(0x70, float:1.57E-43)
            boolean r2 = r6.mBaselineAligned
            int[] r1 = r6.mMaxAscent
            int[] r0 = r6.mMaxDescent
            int r3 = android.support.p000v4.view.ViewCompat.getLayoutDirection(r31)
            int r11 = android.support.p000v4.view.GravityCompat.getAbsoluteGravity(r4, r3)
            r17 = 2
            r12 = 1
            if (r11 == r12) goto L_0x0052
            r12 = 5
            if (r11 == r12) goto L_0x0046
            int r11 = r31.getPaddingLeft()
        L_0x0043:
            r18 = r3
            goto L_0x0061
        L_0x0046:
            int r11 = r31.getPaddingLeft()
            int r11 = r11 + r34
            int r11 = r11 - r32
            int r12 = r6.mTotalLength
            int r11 = r11 - r12
            goto L_0x0043
        L_0x0052:
            int r11 = r31.getPaddingLeft()
            int r12 = r34 - r32
            r18 = r3
            int r3 = r6.mTotalLength
            int r12 = r12 - r3
            int r12 = r12 / 2
            int r11 = r11 + r12
        L_0x0061:
            r3 = r11
            r11 = 0
            r12 = 1
            if (r9 == 0) goto L_0x0069
            int r11 = r5 + -1
            r12 = -1
        L_0x0069:
            r19 = 0
            r20 = r3
        L_0x006d:
            r3 = r19
            if (r3 >= r5) goto L_0x015f
            int r19 = r12 * r3
            int r7 = r11 + r19
            android.view.View r8 = r6.getVirtualChildAt(r7)
            if (r8 != 0) goto L_0x008f
            int r19 = r6.measureNullChild(r7)
            int r20 = r20 + r19
            r26 = r0
            r28 = r1
            r25 = r2
            r22 = r4
            r27 = r5
            r30 = r9
            goto L_0x014e
        L_0x008f:
            r21 = r3
            int r3 = r8.getVisibility()
            r22 = r4
            r4 = 8
            if (r3 == r4) goto L_0x0142
            int r19 = r8.getMeasuredWidth()
            int r23 = r8.getMeasuredHeight()
            r3 = -1
            android.view.ViewGroup$LayoutParams r4 = r8.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r4 = (android.support.p003v7.widget.LinearLayoutCompat.LayoutParams) r4
            r24 = r3
            r3 = -1
            if (r2 == 0) goto L_0x00bb
            r25 = r2
            int r2 = r4.height
            if (r2 == r3) goto L_0x00bd
            int r2 = r8.getBaseline()
            goto L_0x00bf
        L_0x00bb:
            r25 = r2
        L_0x00bd:
            r2 = r24
        L_0x00bf:
            int r3 = r4.gravity
            if (r3 >= 0) goto L_0x00c5
            r3 = r16
        L_0x00c5:
            r24 = r3
            r3 = r24 & 112(0x70, float:1.57E-43)
            r27 = r5
            r5 = 16
            if (r3 == r5) goto L_0x00fb
            r5 = 48
            if (r3 == r5) goto L_0x00ed
            r5 = 80
            if (r3 == r5) goto L_0x00d9
            r3 = r10
            goto L_0x0107
        L_0x00d9:
            int r3 = r14 - r23
            int r5 = r4.bottomMargin
            int r3 = r3 - r5
            r5 = -1
            if (r2 == r5) goto L_0x0107
            int r5 = r8.getMeasuredHeight()
            int r5 = r5 - r2
            r26 = r0[r17]
            int r26 = r26 - r5
            int r3 = r3 - r26
            goto L_0x0107
        L_0x00ed:
            int r3 = r4.topMargin
            int r3 = r3 + r10
            r5 = -1
            if (r2 == r5) goto L_0x0107
            r5 = 1
            r26 = r1[r5]
            int r26 = r26 - r2
            int r3 = r3 + r26
            goto L_0x0107
        L_0x00fb:
            int r3 = r15 - r23
            int r3 = r3 / 2
            int r3 = r3 + r10
            int r5 = r4.topMargin
            int r3 = r3 + r5
            int r5 = r4.bottomMargin
            int r3 = r3 - r5
        L_0x0107:
            boolean r5 = r6.hasDividerBeforeChildAt(r7)
            if (r5 == 0) goto L_0x0112
            int r5 = r6.mDividerWidth
            int r20 = r20 + r5
        L_0x0112:
            int r5 = r4.leftMargin
            int r20 = r20 + r5
            int r5 = r6.getLocationOffset(r8)
            int r5 = r20 + r5
            r26 = r0
            r0 = r6
            r28 = r1
            r1 = r8
            r29 = r2
            r2 = r5
            r5 = r4
            r4 = r19
            r30 = r9
            r9 = r5
            r5 = r23
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r0 = r9.rightMargin
            int r0 = r19 + r0
            int r1 = r6.getNextLocationOffset(r8)
            int r0 = r0 + r1
            int r20 = r20 + r0
            int r0 = r6.getChildrenSkipCount(r8, r7)
            int r3 = r21 + r0
            goto L_0x014e
        L_0x0142:
            r26 = r0
            r28 = r1
            r25 = r2
            r27 = r5
            r30 = r9
            r3 = r21
        L_0x014e:
            r0 = 1
            int r19 = r3 + 1
            r4 = r22
            r2 = r25
            r0 = r26
            r5 = r27
            r1 = r28
            r9 = r30
            goto L_0x006d
        L_0x015f:
            r26 = r0
            r28 = r1
            r25 = r2
            r22 = r4
            r27 = r5
            r30 = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.LinearLayoutCompat.layoutHorizontal(int, int, int, int):void");
    }

    private void setChildFrame(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
    }

    public void setOrientation(int orientation) {
        if (this.mOrientation != orientation) {
            this.mOrientation = orientation;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int gravity) {
        if (this.mGravity != gravity) {
            if ((8388615 & gravity) == 0) {
                gravity |= GravityCompat.START;
            }
            if ((gravity & 112) == 0) {
                gravity |= 48;
            }
            this.mGravity = gravity;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int horizontalGravity) {
        int gravity = horizontalGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((8388615 & this.mGravity) != gravity) {
            this.mGravity = (this.mGravity & -8388616) | gravity;
            requestLayout();
        }
    }

    public void setVerticalGravity(int verticalGravity) {
        int gravity = verticalGravity & 112;
        if ((this.mGravity & 112) != gravity) {
            this.mGravity = (this.mGravity & -113) | gravity;
            requestLayout();
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(LinearLayoutCompat.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(LinearLayoutCompat.class.getName());
    }

    /* renamed from: android.support.v7.widget.LinearLayoutCompat$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.gravity = -1;
            TypedArray a = c.obtainStyledAttributes(attrs, C0400R.styleable.LinearLayoutCompat_Layout);
            this.weight = a.getFloat(C0400R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = a.getInt(C0400R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            a.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int width, int height, float weight2) {
            super(width, height);
            this.gravity = -1;
            this.weight = weight2;
        }

        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams source) {
            super(source);
            this.gravity = -1;
            this.weight = source.weight;
            this.gravity = source.gravity;
        }
    }
}
