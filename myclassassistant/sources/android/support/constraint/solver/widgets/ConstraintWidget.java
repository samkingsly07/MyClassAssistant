package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintWidgetGroup mBelongingGroup;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    boolean mOptimizerMeasured;
    ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    int[] mResolvedMatchConstraintDefault;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;

    /* renamed from: mX */
    protected int f5mX;

    /* renamed from: mY */
    protected int f6mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int maxWidth) {
        this.mMaxDimension[0] = maxWidth;
    }

    public void setMaxHeight(int maxHeight) {
        this.mMaxDimension[1] = maxHeight;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f5mX = 0;
        this.f6mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        this.mWeight[0] = -1.0f;
        this.mWeight[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMaxDimension[0] = Integer.MAX_VALUE;
        this.mMaxDimension[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        if (this.mResolutionWidth != null) {
            this.mResolutionWidth.reset();
        }
        if (this.mResolutionHeight != null) {
            this.mResolutionHeight.reset();
        }
        this.mBelongingGroup = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }

    public void analyze(int optimizationLevel) {
        Optimizer.analyze(optimizationLevel, this);
    }

    public void resolve() {
    }

    public boolean isFullyResolved() {
        if (this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1) {
            return true;
        }
        return false;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f5mX = 0;
        this.f6mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int x, int y, int width, int height) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f5mX = 0;
        this.f6mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.f5mX = x;
        this.f6mY = y;
        this.mWidth = width;
        this.mHeight = height;
        addAnchors();
        forceUpdateDrawPosition();
    }

    public ConstraintWidget(int width, int height) {
        this(0, 0, width, height);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        return (this instanceof ConstraintWidgetContainer) && (this.mParent == null || !(this.mParent instanceof ConstraintWidgetContainer));
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget widget = getParent();
        if (widget == null) {
            return false;
        }
        while (widget != null) {
            if (widget instanceof ConstraintWidgetContainer) {
                return true;
            }
            widget = widget.getParent();
        }
        return false;
    }

    public boolean hasAncestor(ConstraintWidget widget) {
        ConstraintWidget parent = getParent();
        if (parent == widget) {
            return true;
        }
        if (parent == widget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == widget || parent == widget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget root = this;
        while (root.getParent() != null) {
            root = root.getParent();
        }
        if (root instanceof WidgetContainer) {
            return (WidgetContainer) root;
        }
        return null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget widget) {
        this.mParent = widget;
    }

    public void setWidthWrapContent(boolean widthWrapContent) {
        this.mIsWidthWrapContent = widthWrapContent;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean heightWrapContent) {
        this.mIsHeightWrapContent = heightWrapContent;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget target, float angle, int radius) {
        immediateConnect(ConstraintAnchor.Type.CENTER, target, ConstraintAnchor.Type.CENTER, radius, 0);
        this.mCircleConstraintAngle = angle;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public void setVisibility(int visibility) {
        this.mVisibility = visibility;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String name) {
        this.mDebugName = name;
    }

    public void setDebugSolverName(LinearSystem system, String name) {
        this.mDebugName = name;
        SolverVariable left = system.createObjectVariable(this.mLeft);
        SolverVariable top = system.createObjectVariable(this.mTop);
        SolverVariable right = system.createObjectVariable(this.mRight);
        SolverVariable bottom = system.createObjectVariable(this.mBottom);
        left.setName(name + ".left");
        top.setName(name + ".top");
        right.setName(name + ".right");
        bottom.setName(name + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable baseline = system.createObjectVariable(this.mBaseline);
            baseline.setName(name + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem system) {
        SolverVariable createObjectVariable = system.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = system.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = system.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = system.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            system.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f5mX);
        sb.append(", ");
        sb.append(this.f6mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawX() {
        return this.mDrawX;
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getX() {
        return this.f5mX;
    }

    public int getY() {
        return this.f6mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int w;
        int w2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return w2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            w = Math.max(this.mMatchConstraintMinWidth, w2);
        } else if (this.mMatchConstraintMinWidth > 0) {
            w = this.mMatchConstraintMinWidth;
            this.mWidth = w;
        } else {
            w = 0;
        }
        if (this.mMatchConstraintMaxWidth <= 0 || this.mMatchConstraintMaxWidth >= w) {
            return w;
        }
        return this.mMatchConstraintMaxWidth;
    }

    public int getOptimizerWrapHeight() {
        int h;
        int h2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return h2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            h = Math.max(this.mMatchConstraintMinHeight, h2);
        } else if (this.mMatchConstraintMinHeight > 0) {
            h = this.mMatchConstraintMinHeight;
            this.mHeight = h;
        } else {
            h = 0;
        }
        if (this.mMatchConstraintMaxHeight <= 0 || this.mMatchConstraintMaxHeight >= h) {
            return h;
        }
        return this.mMatchConstraintMaxHeight;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getLength(int orientation) {
        if (orientation == 0) {
            return getWidth();
        }
        if (orientation == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.f5mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.f6mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int orientation) {
        if (orientation == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (orientation == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int x) {
        this.f5mX = x;
    }

    public void setY(int y) {
        this.f6mY = y;
    }

    public void setOrigin(int x, int y) {
        this.f5mX = x;
        this.f6mY = y;
    }

    public void setOffset(int x, int y) {
        this.mOffsetX = x;
        this.mOffsetY = y;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int goneMargin) {
        switch (type) {
            case LEFT:
                this.mLeft.mGoneMargin = goneMargin;
                return;
            case TOP:
                this.mTop.mGoneMargin = goneMargin;
                return;
            case RIGHT:
                this.mRight.mGoneMargin = goneMargin;
                return;
            case BOTTOM:
                this.mBottom.mGoneMargin = goneMargin;
                return;
            default:
                return;
        }
    }

    public void updateDrawPosition() {
        int left = this.f5mX;
        int top = this.f6mY;
        int right = this.f5mX + this.mWidth;
        int bottom = this.f6mY + this.mHeight;
        this.mDrawX = left;
        this.mDrawY = top;
        this.mDrawWidth = right - left;
        this.mDrawHeight = bottom - top;
    }

    public void forceUpdateDrawPosition() {
        int left = this.f5mX;
        int top = this.f6mY;
        int right = this.f5mX + this.mWidth;
        int bottom = this.f6mY + this.mHeight;
        this.mDrawX = left;
        this.mDrawY = top;
        this.mDrawWidth = right - left;
        this.mDrawHeight = bottom - top;
    }

    public void setDrawOrigin(int x, int y) {
        this.mDrawX = x - this.mOffsetX;
        this.mDrawY = y - this.mOffsetY;
        this.f5mX = this.mDrawX;
        this.f6mY = this.mDrawY;
    }

    public void setDrawX(int x) {
        this.mDrawX = x - this.mOffsetX;
        this.f5mX = this.mDrawX;
    }

    public void setDrawY(int y) {
        this.mDrawY = y - this.mOffsetY;
        this.f6mY = this.mDrawY;
    }

    public void setDrawWidth(int drawWidth) {
        this.mDrawWidth = drawWidth;
    }

    public void setDrawHeight(int drawHeight) {
        this.mDrawHeight = drawHeight;
    }

    public void setWidth(int w) {
        this.mWidth = w;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHeight(int h) {
        this.mHeight = h;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setLength(int length, int orientation) {
        if (orientation == 0) {
            setWidth(length);
        } else if (orientation == 1) {
            setHeight(length);
        }
    }

    public void setHorizontalMatchStyle(int horizontalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultWidth = horizontalMatchStyle;
        this.mMatchConstraintMinWidth = min;
        this.mMatchConstraintMaxWidth = max;
        this.mMatchConstraintPercentWidth = percent;
        if (percent < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int verticalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultHeight = verticalMatchStyle;
        this.mMatchConstraintMinHeight = min;
        this.mMatchConstraintMaxHeight = max;
        this.mMatchConstraintPercentHeight = percent;
        if (percent < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setDimensionRatio(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 <= 0 || commaIndex2 >= len - 1) {
            commaIndex = 0;
        } else {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase("W")) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex < 0 || colonIndex >= len - 1) {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.mDimensionRatio = dimensionRatio;
            this.mDimensionRatioSide = dimensionRatioSide;
        }
    }

    public void setDimensionRatio(float ratio, int dimensionRatioSide) {
        this.mDimensionRatio = ratio;
        this.mDimensionRatioSide = dimensionRatioSide;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float horizontalBiasPercent) {
        this.mHorizontalBiasPercent = horizontalBiasPercent;
    }

    public void setVerticalBiasPercent(float verticalBiasPercent) {
        this.mVerticalBiasPercent = verticalBiasPercent;
    }

    public void setMinWidth(int w) {
        if (w < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = w;
        }
    }

    public void setMinHeight(int h) {
        if (h < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = h;
        }
    }

    public void setWrapWidth(int w) {
        this.mWrapWidth = w;
    }

    public void setWrapHeight(int h) {
        this.mWrapHeight = h;
    }

    public void setDimension(int w, int h) {
        this.mWidth = w;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mHeight = h;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setFrame(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.f5mX = left;
        this.f6mY = top;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
            w = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h < this.mHeight) {
            h = this.mHeight;
        }
        this.mWidth = w;
        this.mHeight = h;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mOptimizerMeasured = true;
    }

    public void setFrame(int start, int end, int orientation) {
        if (orientation == 0) {
            setHorizontalDimension(start, end);
        } else if (orientation == 1) {
            setVerticalDimension(start, end);
        }
        this.mOptimizerMeasured = true;
    }

    public void setHorizontalDimension(int left, int right) {
        this.f5mX = left;
        this.mWidth = right - left;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setVerticalDimension(int top, int bottom) {
        this.f6mY = top;
        this.mHeight = bottom - top;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int orientation) {
        if (orientation == 0) {
            return this.mRelX;
        }
        if (orientation == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int offset, int orientation) {
        if (orientation == 0) {
            this.mRelX = offset;
        } else if (orientation == 1) {
            this.mRelY = offset;
        }
    }

    public void setBaselineDistance(int baseline) {
        this.mBaselineDistance = baseline;
    }

    public void setCompanionWidget(Object companion) {
        this.mCompanionWidget = companion;
    }

    public void setContainerItemSkip(int skip) {
        if (skip >= 0) {
            this.mContainerItemSkip = skip;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float horizontalWeight) {
        this.mWeight[0] = horizontalWeight;
    }

    public void setVerticalWeight(float verticalWeight) {
        this.mWeight[1] = verticalWeight;
    }

    public void setHorizontalChainStyle(int horizontalChainStyle) {
        this.mHorizontalChainStyle = horizontalChainStyle;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int verticalChainStyle) {
        this.mVerticalChainStyle = verticalChainStyle;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connectedTo(ConstraintWidget source) {
    }

    public void immediateConnect(ConstraintAnchor.Type startType, ConstraintWidget target, ConstraintAnchor.Type endType, int margin, int goneMargin) {
        ConstraintAnchor startAnchor = getAnchor(startType);
        startAnchor.connect(target.getAnchor(endType), margin, goneMargin, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public void connect(ConstraintAnchor from, ConstraintAnchor to, int margin, int creator) {
        connect(from, to, margin, ConstraintAnchor.Strength.STRONG, creator);
    }

    public void connect(ConstraintAnchor from, ConstraintAnchor to, int margin) {
        connect(from, to, margin, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor from, ConstraintAnchor to, int margin, ConstraintAnchor.Strength strength, int creator) {
        if (from.getOwner() == this) {
            connect(from.getType(), to.getOwner(), to.getType(), margin, strength, creator);
        }
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo, int margin) {
        connect(constraintFrom, target, constraintTo, margin, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo) {
        connect(constraintFrom, target, constraintTo, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo, int margin, ConstraintAnchor.Strength strength) {
        connect(constraintFrom, target, constraintTo, margin, strength, 0);
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo, int margin, ConstraintAnchor.Strength strength, int creator) {
        int margin2;
        ConstraintAnchor bottom;
        ConstraintAnchor.Type type = constraintFrom;
        ConstraintWidget constraintWidget = target;
        ConstraintAnchor.Type type2 = constraintTo;
        int i = creator;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor bottom2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean centerX = false;
                boolean centerY = false;
                if ((left == null || !left.isConnected()) && (right == null || !right.isConnected())) {
                    ConstraintWidget constraintWidget2 = constraintWidget;
                    ConstraintAnchor.Strength strength2 = strength;
                    bottom = bottom2;
                    int i2 = i;
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.LEFT, 0, strength2, i2);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget2, ConstraintAnchor.Type.RIGHT, 0, strength2, i2);
                    centerX = true;
                } else {
                    bottom = bottom2;
                }
                if ((top == null || !top.isConnected()) && (bottom == null || !bottom.isConnected())) {
                    ConstraintWidget constraintWidget3 = constraintWidget;
                    ConstraintAnchor.Strength strength3 = strength;
                    int i3 = i;
                    connect(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.TOP, 0, strength3, i3);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget3, ConstraintAnchor.Type.BOTTOM, 0, strength3, i3);
                    centerY = true;
                }
                if (centerX && centerY) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, i);
                } else if (centerX) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, i);
                } else if (centerY) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, i);
                }
            } else if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                ConstraintWidget constraintWidget4 = constraintWidget;
                ConstraintAnchor.Type type3 = type2;
                ConstraintAnchor.Strength strength4 = strength;
                int i4 = i;
                connect(ConstraintAnchor.Type.LEFT, constraintWidget4, type3, 0, strength4, i4);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget4, type3, 0, strength4, i4);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0, i);
            } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                ConstraintWidget constraintWidget5 = constraintWidget;
                ConstraintAnchor.Type type4 = type2;
                ConstraintAnchor.Strength strength5 = strength;
                int i5 = i;
                connect(ConstraintAnchor.Type.TOP, constraintWidget5, type4, 0, strength5, i5);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget5, type4, 0, strength5, i5);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0, i);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor left2 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = target.getAnchor(constraintTo);
            ConstraintAnchor right2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            left2.connect(targetAnchor, 0, i);
            right2.connect(targetAnchor, 0, i);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(targetAnchor, 0, i);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor targetAnchor2 = target.getAnchor(constraintTo);
            getAnchor(ConstraintAnchor.Type.TOP).connect(targetAnchor2, 0, i);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(targetAnchor2, 0, i);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(targetAnchor2, 0, i);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0, i);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(target.getAnchor(constraintTo), 0, i);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0, i);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(target.getAnchor(constraintTo), 0, i);
        } else {
            ConstraintAnchor fromAnchor = getAnchor(constraintFrom);
            ConstraintAnchor toAnchor = target.getAnchor(constraintTo);
            if (fromAnchor.isValidConnection(toAnchor)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor top2 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor bottom3 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (top2 != null) {
                        top2.reset();
                    }
                    if (bottom3 != null) {
                        bottom3.reset();
                    }
                    margin2 = 0;
                } else {
                    if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor baseline = getAnchor(ConstraintAnchor.Type.BASELINE);
                        if (baseline != null) {
                            baseline.reset();
                        }
                        ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (center.getTarget() != toAnchor) {
                            center.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(constraintFrom).getOpposite();
                        ConstraintAnchor centerY2 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                        if (centerY2.isConnected()) {
                            opposite.reset();
                            centerY2.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor center2 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (center2.getTarget() != toAnchor) {
                            center2.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(constraintFrom).getOpposite();
                        ConstraintAnchor centerX2 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                        if (centerX2.isConnected()) {
                            opposite2.reset();
                            centerX2.reset();
                        }
                    }
                    margin2 = margin;
                }
                fromAnchor.connect(toAnchor, margin2, strength, i);
                toAnchor.getOwner().connectedTo(fromAnchor.getOwner());
                return;
            }
        }
        ConstraintAnchor.Strength strength6 = strength;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (!(this instanceof ConstraintWidgetContainer)) {
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getWidth() > getMinWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
            if (getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
                return;
            }
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor anchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor centerX = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor centerY = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (anchor == center) {
                if (left.isConnected() && right.isConnected() && left.getTarget() == right.getTarget()) {
                    left.reset();
                    right.reset();
                }
                if (top.isConnected() && bottom.isConnected() && top.getTarget() == bottom.getTarget()) {
                    top.reset();
                    bottom.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == centerX) {
                if (left.isConnected() && right.isConnected() && left.getTarget().getOwner() == right.getTarget().getOwner()) {
                    left.reset();
                    right.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (anchor == centerY) {
                if (top.isConnected() && bottom.isConnected() && top.getTarget().getOwner() == bottom.getTarget().getOwner()) {
                    top.reset();
                    bottom.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == left || anchor == right) {
                if (left.isConnected() && left.getTarget() == right.getTarget()) {
                    center.reset();
                }
            } else if ((anchor == top || anchor == bottom) && top.isConnected() && top.getTarget() == bottom.getTarget()) {
                center.reset();
            }
            anchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int mAnchorsSize = this.mAnchors.size();
            for (int i = 0; i < mAnchorsSize; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetAnchors(int connectionCreator) {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int mAnchorsSize = this.mAnchors.size();
            for (int i = 0; i < mAnchorsSize; i++) {
                ConstraintAnchor anchor = this.mAnchors.get(i);
                if (connectionCreator == anchor.getConnectionCreator()) {
                    if (anchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    anchor.reset();
                }
            }
        }
    }

    public void disconnectWidget(ConstraintWidget widget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int anchorsSize = anchors.size();
        for (int i = 0; i < anchorsSize; i++) {
            ConstraintAnchor anchor = anchors.get(i);
            if (anchor.isConnected() && anchor.getTarget().getOwner() == widget) {
                anchor.reset();
            }
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget widget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int anchorsSize = anchors.size();
        for (int i = 0; i < anchorsSize; i++) {
            ConstraintAnchor anchor = anchors.get(i);
            if (anchor.isConnected() && anchor.getTarget().getOwner() == widget && anchor.getConnectionCreator() == 2) {
                anchor.reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type anchorType) {
        switch (anchorType) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int orientation) {
        if (orientation == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (orientation == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[0] = behaviour;
        if (behaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[1] = behaviour;
        if (behaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) {
            return true;
        }
        if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != this.mRight) {
            return false;
        }
        return true;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget found = null;
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) {
            return true;
        }
        if (this.mBottom.mTarget == null || this.mBottom.mTarget.mTarget != this.mBottom) {
            return false;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget found = null;
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    private boolean isChainHead(int orientation) {
        int offset = orientation * 2;
        return (this.mListAnchors[offset].mTarget == null || this.mListAnchors[offset].mTarget.mTarget == this.mListAnchors[offset] || this.mListAnchors[offset + 1].mTarget == null || this.mListAnchors[offset + 1].mTarget.mTarget != this.mListAnchors[offset + 1]) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c2, code lost:
        if (r15.mResolvedDimensionRatioSide == -1) goto L_0x01c6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x027c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(android.support.constraint.solver.LinearSystem r58) {
        /*
            r57 = this;
            r15 = r57
            r13 = r58
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mLeft
            android.support.constraint.solver.SolverVariable r36 = r13.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mRight
            android.support.constraint.solver.SolverVariable r12 = r13.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mTop
            android.support.constraint.solver.SolverVariable r11 = r13.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBottom
            android.support.constraint.solver.SolverVariable r10 = r13.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.SolverVariable r9 = r13.createObjectVariable(r0)
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            r5 = 8
            r8 = 0
            r7 = 1
            if (r4 == 0) goto L_0x00b6
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            if (r4 == 0) goto L_0x003e
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r4.mListDimensionBehaviors
            r4 = r4[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r6) goto L_0x003e
            r4 = 1
            goto L_0x003f
        L_0x003e:
            r4 = 0
        L_0x003f:
            r2 = r4
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            if (r4 == 0) goto L_0x0050
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r4.mListDimensionBehaviors
            r4 = r4[r7]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r6) goto L_0x0050
            r4 = 1
            goto L_0x0051
        L_0x0050:
            r4 = 0
        L_0x0051:
            r3 = r4
            boolean r4 = r15.isChainHead(r8)
            if (r4 == 0) goto L_0x0061
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r4 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r4
            r4.addChain(r15, r8)
            r0 = 1
            goto L_0x0065
        L_0x0061:
            boolean r0 = r57.isInHorizontalChain()
        L_0x0065:
            boolean r4 = r15.isChainHead(r7)
            if (r4 == 0) goto L_0x0074
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r4 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r4
            r4.addChain(r15, r7)
            r1 = 1
            goto L_0x0078
        L_0x0074:
            boolean r1 = r57.isInVerticalChain()
        L_0x0078:
            if (r2 == 0) goto L_0x0095
            int r4 = r15.mVisibility
            if (r4 == r5) goto L_0x0095
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x0095
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x0095
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mRight
            android.support.constraint.solver.SolverVariable r4 = r13.createObjectVariable(r4)
            r13.addGreaterThan(r4, r12, r8, r7)
        L_0x0095:
            if (r3 == 0) goto L_0x00b6
            int r4 = r15.mVisibility
            if (r4 == r5) goto L_0x00b6
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x00b6
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x00b6
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mBaseline
            if (r4 != 0) goto L_0x00b6
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mBottom
            android.support.constraint.solver.SolverVariable r4 = r13.createObjectVariable(r4)
            r13.addGreaterThan(r4, r10, r8, r7)
        L_0x00b6:
            r37 = r0
            r38 = r1
            r1 = r3
            int r0 = r15.mWidth
            int r3 = r15.mMinWidth
            if (r0 >= r3) goto L_0x00c3
            int r0 = r15.mMinWidth
        L_0x00c3:
            int r3 = r15.mHeight
            int r4 = r15.mMinHeight
            if (r3 >= r4) goto L_0x00cb
            int r3 = r15.mMinHeight
        L_0x00cb:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r15.mListDimensionBehaviors
            r4 = r4[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 == r6) goto L_0x00d5
            r4 = 1
            goto L_0x00d6
        L_0x00d5:
            r4 = 0
        L_0x00d6:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r15.mListDimensionBehaviors
            r6 = r6[r7]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 == r14) goto L_0x00e0
            r6 = 1
            goto L_0x00e1
        L_0x00e0:
            r6 = 0
        L_0x00e1:
            r14 = 0
            int r7 = r15.mDimensionRatioSide
            r15.mResolvedDimensionRatioSide = r7
            float r7 = r15.mDimensionRatio
            r15.mResolvedDimensionRatio = r7
            int r7 = r15.mMatchConstraintDefaultWidth
            int r8 = r15.mMatchConstraintDefaultHeight
            float r5 = r15.mDimensionRatio
            r16 = 0
            int r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            r42 = r12
            if (r5 <= 0) goto L_0x01a3
            int r5 = r15.mVisibility
            r12 = 8
            if (r5 == r12) goto L_0x01a3
            r14 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r12 = 0
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r12) goto L_0x010b
            if (r7 != 0) goto L_0x010b
            r7 = 3
        L_0x010b:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r12 = 1
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r12) goto L_0x0117
            if (r8 != 0) goto L_0x0117
            r8 = 3
        L_0x0117:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r12 = 0
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r44 = r0
            r0 = 3
            if (r5 != r12) goto L_0x0135
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r12 = 1
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r12) goto L_0x0135
            if (r7 != r0) goto L_0x0135
            if (r8 != r0) goto L_0x0135
            r15.setupDimensionRatio(r2, r1, r4, r6)
            goto L_0x01a5
        L_0x0135:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r12 = 0
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r12) goto L_0x0168
            if (r7 != r0) goto L_0x0168
            r0 = 0
            r15.mResolvedDimensionRatioSide = r0
            float r0 = r15.mResolvedDimensionRatio
            int r5 = r15.mHeight
            float r5 = (float) r5
            float r0 = r0 * r5
            int r0 = (int) r0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r12 = 1
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 == r12) goto L_0x015d
            r5 = 4
            r14 = 0
            r46 = r0
            r47 = r3
            r41 = r5
            goto L_0x0163
        L_0x015d:
            r46 = r0
            r47 = r3
            r41 = r7
        L_0x0163:
            r44 = r8
            r45 = r14
            goto L_0x01af
        L_0x0168:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r12 = 1
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r12) goto L_0x01a5
            if (r8 != r0) goto L_0x01a5
            r0 = 1
            r15.mResolvedDimensionRatioSide = r0
            int r0 = r15.mDimensionRatioSide
            r5 = -1
            if (r0 != r5) goto L_0x0182
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = r15.mResolvedDimensionRatio
            float r0 = r0 / r5
            r15.mResolvedDimensionRatio = r0
        L_0x0182:
            float r0 = r15.mResolvedDimensionRatio
            int r5 = r15.mWidth
            float r5 = (float) r5
            float r0 = r0 * r5
            int r0 = (int) r0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.mListDimensionBehaviors
            r5 = 0
            r3 = r3[r5]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r5) goto L_0x01a0
            r3 = 4
            r14 = 0
            r47 = r0
            r41 = r7
            r45 = r14
            r46 = r44
            r44 = r3
            goto L_0x01af
        L_0x01a0:
            r47 = r0
            goto L_0x01a7
        L_0x01a3:
            r44 = r0
        L_0x01a5:
            r47 = r3
        L_0x01a7:
            r41 = r7
            r45 = r14
            r46 = r44
            r44 = r8
        L_0x01af:
            int[] r0 = r15.mResolvedMatchConstraintDefault
            r3 = 0
            r0[r3] = r41
            int[] r0 = r15.mResolvedMatchConstraintDefault
            r7 = 1
            r0[r7] = r44
            if (r45 == 0) goto L_0x01c8
            int r0 = r15.mResolvedDimensionRatioSide
            if (r0 == 0) goto L_0x01c5
            int r0 = r15.mResolvedDimensionRatioSide
            r12 = -1
            if (r0 != r12) goto L_0x01c9
            goto L_0x01c6
        L_0x01c5:
            r12 = -1
        L_0x01c6:
            r14 = 1
            goto L_0x01ca
        L_0x01c8:
            r12 = -1
        L_0x01c9:
            r14 = 0
        L_0x01ca:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r3 = 0
            r0 = r0[r3]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x01d9
            boolean r0 = r15 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x01d9
            r0 = 1
            goto L_0x01da
        L_0x01d9:
            r0 = 0
        L_0x01da:
            r39 = r6
            r6 = r0
            r0 = 1
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.mCenter
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x01e7
            r0 = 0
        L_0x01e7:
            r22 = r0
            int r0 = r15.mHorizontalResolution
            r8 = 2
            r23 = 0
            if (r0 == r8) goto L_0x0267
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x01fd
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mRight
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            goto L_0x01ff
        L_0x01fd:
            r0 = r23
        L_0x01ff:
            r43 = r4
            r4 = r0
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0210
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mLeft
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            r3 = r0
            goto L_0x0212
        L_0x0210:
            r3 = r23
        L_0x0212:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r16 = 0
            r5 = r0[r16]
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r15.mRight
            int r12 = r15.f5mX
            r49 = r11
            int r11 = r15.mMinWidth
            int[] r7 = r15.mMaxDimension
            r17 = r7[r16]
            float r7 = r15.mHorizontalBiasPercent
            r50 = r3
            int r3 = r15.mMatchConstraintMinWidth
            r51 = r4
            int r4 = r15.mMatchConstraintMaxWidth
            r52 = r6
            float r6 = r15.mMatchConstraintPercentWidth
            r18 = r0
            r0 = r15
            r40 = r1
            r1 = r13
            r53 = r2
            r19 = r7
            r7 = r18
            r24 = 0
            r54 = r9
            r9 = r12
            r48 = r10
            r10 = r46
            r12 = r49
            r55 = r12
            r12 = r17
            r13 = r19
            r15 = r37
            r16 = r41
            r17 = r3
            r18 = r4
            r19 = r6
            r20 = r22
            r3 = r50
            r4 = r51
            r6 = r52
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0275
        L_0x0267:
            r40 = r1
            r53 = r2
            r43 = r4
            r54 = r9
            r48 = r10
            r55 = r11
            r24 = 0
        L_0x0275:
            r7 = r57
            int r0 = r7.mVerticalResolution
            r1 = 2
            if (r0 != r1) goto L_0x027d
            return
        L_0x027d:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r7.mListDimensionBehaviors
            r1 = 1
            r0 = r0[r1]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r2) goto L_0x028d
            boolean r0 = r7 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x028d
            r21 = 1
            goto L_0x028f
        L_0x028d:
            r21 = 0
        L_0x028f:
            if (r45 == 0) goto L_0x029d
            int r0 = r7.mResolvedDimensionRatioSide
            if (r0 == r1) goto L_0x029a
            int r0 = r7.mResolvedDimensionRatioSide
            r2 = -1
            if (r0 != r2) goto L_0x029d
        L_0x029a:
            r29 = 1
            goto L_0x029f
        L_0x029d:
            r29 = 0
        L_0x029f:
            int r0 = r7.mBaselineDistance
            if (r0 <= 0) goto L_0x02e0
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            int r0 = r0.state
            if (r0 != r1) goto L_0x02bd
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r8 = r58
            r0.addResolvedValue(r8)
            r10 = r54
            r9 = r55
            goto L_0x02e6
        L_0x02bd:
            r8 = r58
            int r0 = r57.getBaselineDistance()
            r2 = 6
            r10 = r54
            r9 = r55
            r8.addEquality(r10, r9, r0, r2)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mBaseline
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x02e6
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mBaseline
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            android.support.constraint.solver.SolverVariable r0 = r8.createObjectVariable(r0)
            r3 = 0
            r8.addEquality(r10, r0, r3, r2)
            r0 = 0
            r11 = r0
            goto L_0x02e8
        L_0x02e0:
            r10 = r54
            r9 = r55
            r8 = r58
        L_0x02e6:
            r11 = r22
        L_0x02e8:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r7.mParent
            if (r0 == 0) goto L_0x02f7
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r7.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            android.support.constraint.solver.SolverVariable r0 = r8.createObjectVariable(r0)
            r19 = r0
            goto L_0x02f9
        L_0x02f7:
            r19 = r23
        L_0x02f9:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r7.mParent
            if (r0 == 0) goto L_0x0308
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r7.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTop
            android.support.constraint.solver.SolverVariable r0 = r8.createObjectVariable(r0)
            r18 = r0
            goto L_0x030a
        L_0x0308:
            r18 = r23
        L_0x030a:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r7.mListDimensionBehaviors
            r20 = r0[r1]
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r7.mBottom
            int r3 = r7.f6mY
            int r4 = r7.mMinHeight
            int[] r5 = r7.mMaxDimension
            r27 = r5[r1]
            float r5 = r7.mVerticalBiasPercent
            int r6 = r7.mMatchConstraintMinHeight
            int r12 = r7.mMatchConstraintMaxHeight
            float r13 = r7.mMatchConstraintPercentHeight
            r15 = r7
            r16 = r8
            r17 = r40
            r22 = r0
            r23 = r2
            r24 = r3
            r25 = r47
            r26 = r4
            r28 = r5
            r30 = r38
            r31 = r44
            r32 = r6
            r33 = r12
            r34 = r13
            r35 = r11
            r15.applyConstraints(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            if (r45 == 0) goto L_0x0366
            r12 = 6
            int r0 = r7.mResolvedDimensionRatioSide
            if (r0 != r1) goto L_0x0358
            float r5 = r7.mResolvedDimensionRatio
            r0 = r8
            r1 = r48
            r2 = r9
            r3 = r42
            r4 = r36
            r6 = r12
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0366
        L_0x0358:
            float r5 = r7.mResolvedDimensionRatio
            r0 = r8
            r1 = r42
            r2 = r36
            r3 = r48
            r4 = r9
            r6 = r12
            r0.addRatio(r1, r2, r3, r4, r5, r6)
        L_0x0366:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x038c
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r8.addCenterPoint(r7, r0, r1, r2)
        L_0x038c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.addToSolver(android.support.constraint.solver.LinearSystem):void");
    }

    public void setupDimensionRatio(boolean hparentWrapContent, boolean vparentWrapContent, boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (hparentWrapContent && !vparentWrapContent) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!hparentWrapContent && vparentWrapContent) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && hparentWrapContent && vparentWrapContent) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:184:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(android.support.constraint.solver.LinearSystem r45, boolean r46, android.support.constraint.solver.SolverVariable r47, android.support.constraint.solver.SolverVariable r48, android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour r49, boolean r50, android.support.constraint.solver.widgets.ConstraintAnchor r51, android.support.constraint.solver.widgets.ConstraintAnchor r52, int r53, int r54, int r55, int r56, float r57, boolean r58, boolean r59, int r60, int r61, int r62, float r63, boolean r64) {
        /*
            r44 = this;
            r0 = r44
            r10 = r45
            r11 = r47
            r12 = r48
            r13 = r51
            r14 = r52
            r9 = r55
            r8 = r56
            android.support.constraint.solver.SolverVariable r7 = r10.createObjectVariable(r13)
            android.support.constraint.solver.SolverVariable r6 = r10.createObjectVariable(r14)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r51.getTarget()
            android.support.constraint.solver.SolverVariable r5 = r10.createObjectVariable(r1)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r52.getTarget()
            android.support.constraint.solver.SolverVariable r4 = r10.createObjectVariable(r1)
            boolean r1 = r10.graphOptimizer
            r2 = 1
            if (r1 == 0) goto L_0x006c
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r51.getResolutionNode()
            int r1 = r1.state
            if (r1 != r2) goto L_0x006c
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r52.getResolutionNode()
            int r1 = r1.state
            if (r1 != r2) goto L_0x006c
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            if (r1 == 0) goto L_0x0052
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            r18 = r4
            long r3 = r1.resolvedWidgets
            r15 = 1
            long r8 = r3 + r15
            r1.resolvedWidgets = r8
            goto L_0x0054
        L_0x0052:
            r18 = r4
        L_0x0054:
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r51.getResolutionNode()
            r1.addResolvedValue(r10)
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r52.getResolutionNode()
            r1.addResolvedValue(r10)
            if (r59 != 0) goto L_0x006b
            if (r46 == 0) goto L_0x006b
            r1 = 6
            r2 = 0
            r10.addGreaterThan(r12, r6, r2, r1)
        L_0x006b:
            return
        L_0x006c:
            r18 = r4
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            if (r1 == 0) goto L_0x0080
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            long r3 = r1.nonresolvedWidgets
            r8 = 1
            long r11 = r3 + r8
            r1.nonresolvedWidgets = r11
        L_0x0080:
            boolean r11 = r51.isConnected()
            boolean r12 = r52.isConnected()
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mCenter
            boolean r15 = r1.isConnected()
            r1 = 0
            r3 = 0
            if (r11 == 0) goto L_0x0094
            int r3 = r3 + 1
        L_0x0094:
            if (r12 == 0) goto L_0x0098
            int r3 = r3 + 1
        L_0x0098:
            if (r15 == 0) goto L_0x009c
            int r3 = r3 + 1
        L_0x009c:
            r9 = r3
            if (r58 == 0) goto L_0x00a2
            r3 = 3
            r8 = r3
            goto L_0x00a4
        L_0x00a2:
            r8 = r60
        L_0x00a4:
            int[] r3 = android.support.constraint.solver.widgets.ConstraintWidget.C00371.f8x27577131
            int r4 = r49.ordinal()
            r3 = r3[r4]
            r4 = 4
            switch(r3) {
                case 1: goto L_0x00ba;
                case 2: goto L_0x00b8;
                case 3: goto L_0x00b6;
                case 4: goto L_0x00b1;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            goto L_0x00bc
        L_0x00b1:
            r1 = 1
            if (r8 != r4) goto L_0x00bc
            r1 = 0
            goto L_0x00bc
        L_0x00b6:
            r1 = 0
            goto L_0x00bc
        L_0x00b8:
            r1 = 0
            goto L_0x00bc
        L_0x00ba:
            r1 = 0
        L_0x00bc:
            int r3 = r0.mVisibility
            r4 = 8
            if (r3 != r4) goto L_0x00c5
            r3 = 0
            r1 = 0
            goto L_0x00c7
        L_0x00c5:
            r3 = r54
        L_0x00c7:
            r16 = r1
            if (r64 == 0) goto L_0x00e6
            if (r11 != 0) goto L_0x00d7
            if (r12 != 0) goto L_0x00d7
            if (r15 != 0) goto L_0x00d7
            r4 = r53
            r10.addEquality(r7, r4)
            goto L_0x00e8
        L_0x00d7:
            r4 = r53
            if (r11 == 0) goto L_0x00e8
            if (r12 != 0) goto L_0x00e8
            int r1 = r51.getMargin()
            r2 = 6
            r10.addEquality(r7, r5, r1, r2)
            goto L_0x00e8
        L_0x00e6:
            r4 = r53
        L_0x00e8:
            r2 = 3
            if (r16 != 0) goto L_0x011d
            if (r50 == 0) goto L_0x0107
            r1 = 0
            r10.addEquality(r6, r7, r1, r2)
            r14 = r55
            if (r14 <= 0) goto L_0x00fa
            r1 = 6
            r10.addGreaterThan(r6, r7, r14, r1)
            goto L_0x00fb
        L_0x00fa:
            r1 = 6
        L_0x00fb:
            r2 = 2147483647(0x7fffffff, float:NaN)
            r1 = r56
            if (r1 >= r2) goto L_0x010f
            r2 = 6
            r10.addLowerThan(r6, r7, r1, r2)
            goto L_0x010f
        L_0x0107:
            r1 = r56
            r2 = 6
            r14 = r55
            r10.addEquality(r6, r7, r3, r2)
        L_0x010f:
            r19 = r62
            r17 = r3
            r35 = r5
            r33 = r18
            r5 = 6
            r14 = 2
            r18 = r61
            goto L_0x0220
        L_0x011d:
            r1 = r56
            r14 = r55
            r2 = -2
            r1 = r61
            if (r1 != r2) goto L_0x0127
            r1 = r3
        L_0x0127:
            r4 = r62
            if (r4 != r2) goto L_0x012d
            r2 = r3
            r4 = r2
        L_0x012d:
            if (r1 <= 0) goto L_0x0138
            r2 = 6
            r10.addGreaterThan(r6, r7, r1, r2)
            int r3 = java.lang.Math.max(r3, r1)
            goto L_0x0139
        L_0x0138:
            r2 = 6
        L_0x0139:
            if (r4 <= 0) goto L_0x0142
            r10.addLowerThan(r6, r7, r4, r2)
            int r3 = java.lang.Math.min(r3, r4)
        L_0x0142:
            r2 = 1
            if (r8 != r2) goto L_0x0167
            if (r46 == 0) goto L_0x015a
            r2 = 6
            r10.addEquality(r6, r7, r3, r2)
        L_0x014b:
            r31 = r1
            r32 = r3
            r34 = r4
            r35 = r5
            r36 = r6
            r33 = r18
            r14 = 2
            goto L_0x01f2
        L_0x015a:
            r2 = 6
            if (r59 == 0) goto L_0x0162
            r2 = 4
            r10.addEquality(r6, r7, r3, r2)
            goto L_0x014b
        L_0x0162:
            r2 = 1
            r10.addEquality(r6, r7, r3, r2)
            goto L_0x014b
        L_0x0167:
            r2 = 2
            if (r8 != r2) goto L_0x01e5
            r17 = 0
            r19 = 0
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = r51.getType()
            r28 = r1
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r2 == r1) goto L_0x019e
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = r51.getType()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r1 != r2) goto L_0x0181
            goto L_0x019e
        L_0x0181:
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r0.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            android.support.constraint.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r0.mParent
            r29 = r1
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r2.getAnchor(r1)
            android.support.constraint.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            r17 = r1
            goto L_0x01bc
        L_0x019e:
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r0.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            android.support.constraint.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r0.mParent
            r30 = r1
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r2.getAnchor(r1)
            android.support.constraint.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            r17 = r1
            r29 = r30
        L_0x01bc:
            android.support.constraint.solver.ArrayRow r1 = r45.createRow()
            r2 = r28
            r14 = 2
            r19 = 0
            r31 = r2
            r20 = 6
            r2 = r6
            r32 = r3
            r3 = r7
            r34 = r4
            r33 = r18
            r4 = r17
            r35 = r5
            r5 = r29
            r36 = r6
            r6 = r63
            android.support.constraint.solver.ArrayRow r1 = r1.createRowDimensionRatio(r2, r3, r4, r5, r6)
            r10.addConstraint(r1)
            r16 = 0
            goto L_0x01f2
        L_0x01e5:
            r31 = r1
            r32 = r3
            r34 = r4
            r35 = r5
            r36 = r6
            r33 = r18
            r14 = 2
        L_0x01f2:
            if (r16 == 0) goto L_0x0211
            if (r9 == r14) goto L_0x0211
            if (r58 != 0) goto L_0x0211
            r16 = 0
            r1 = r31
            r3 = r32
            int r2 = java.lang.Math.max(r1, r3)
            r4 = r34
            if (r4 <= 0) goto L_0x020a
            int r2 = java.lang.Math.min(r4, r2)
        L_0x020a:
            r6 = r36
            r5 = 6
            r10.addEquality(r6, r7, r2, r5)
            goto L_0x021a
        L_0x0211:
            r1 = r31
            r3 = r32
            r4 = r34
            r6 = r36
            r5 = 6
        L_0x021a:
            r18 = r1
            r17 = r3
            r19 = r4
        L_0x0220:
            if (r64 == 0) goto L_0x03ee
            if (r59 == 0) goto L_0x023d
            r4 = r6
            r14 = r7
            r27 = r8
            r43 = r9
            r38 = r11
            r40 = r12
            r5 = r33
            r11 = r35
            r0 = r47
            r1 = r48
            r2 = 0
            r3 = 6
            r6 = 2
            r12 = r52
            goto L_0x0405
        L_0x023d:
            r1 = 5
            if (r11 != 0) goto L_0x0262
            if (r12 != 0) goto L_0x0262
            if (r15 != 0) goto L_0x0262
            if (r46 == 0) goto L_0x024c
            r4 = 0
            r14 = r48
            r10.addGreaterThan(r14, r6, r4, r1)
        L_0x024c:
            r4 = r6
            r14 = r7
            r27 = r8
            r43 = r9
            r38 = r11
            r40 = r12
            r5 = r33
            r11 = r35
            r0 = r47
            r3 = 6
            r6 = 0
            r12 = r52
            goto L_0x03e2
        L_0x0262:
            r4 = 0
            r14 = r48
            if (r11 == 0) goto L_0x026f
            if (r12 != 0) goto L_0x026f
            if (r46 == 0) goto L_0x024c
            r10.addGreaterThan(r14, r6, r4, r1)
            goto L_0x024c
        L_0x026f:
            if (r11 != 0) goto L_0x02ac
            if (r12 == 0) goto L_0x02ac
            r3 = r52
            r20 = r55
            int r2 = r52.getMargin()
            int r2 = -r2
            r1 = r33
            r10.addEquality(r6, r1, r2, r5)
            if (r46 == 0) goto L_0x0298
            r2 = r47
            r5 = 5
            r10.addGreaterThan(r7, r2, r4, r5)
            r5 = r1
            r0 = r2
            r4 = r6
            r14 = r7
            r27 = r8
            r43 = r9
            r38 = r11
            r40 = r12
            r11 = r35
            goto L_0x02a7
        L_0x0298:
            r5 = r1
            r4 = r6
            r14 = r7
            r27 = r8
            r43 = r9
            r38 = r11
            r40 = r12
            r11 = r35
            r0 = r47
        L_0x02a7:
            r6 = 0
            r12 = r3
            r3 = 6
            goto L_0x03e2
        L_0x02ac:
            r1 = r33
            r2 = r47
            r3 = r52
            r20 = r55
            if (r11 == 0) goto L_0x03d1
            if (r12 == 0) goto L_0x03d1
            r5 = 0
            r21 = 0
            r22 = 5
            if (r16 == 0) goto L_0x032d
            if (r46 == 0) goto L_0x02ca
            if (r20 != 0) goto L_0x02ca
            r37 = r5
            r5 = 6
            r10.addGreaterThan(r6, r7, r4, r5)
            goto L_0x02cd
        L_0x02ca:
            r37 = r5
            r5 = 6
        L_0x02cd:
            if (r8 != 0) goto L_0x02fc
            r23 = 6
            if (r19 > 0) goto L_0x02d9
            if (r18 <= 0) goto L_0x02d6
            goto L_0x02d9
        L_0x02d6:
            r4 = r23
            goto L_0x02e1
        L_0x02d9:
            r23 = 4
            r24 = 1
            r4 = r23
            r37 = r24
        L_0x02e1:
            int r5 = r51.getMargin()
            r38 = r11
            r11 = r35
            r10.addEquality(r7, r11, r5, r4)
            int r5 = r52.getMargin()
            int r5 = -r5
            r10.addEquality(r6, r1, r5, r4)
            if (r19 > 0) goto L_0x02f8
            if (r18 <= 0) goto L_0x02fb
        L_0x02f8:
            r4 = 1
            r21 = r4
        L_0x02fb:
            goto L_0x0335
        L_0x02fc:
            r38 = r11
            r11 = r35
            r4 = 1
            if (r8 != r4) goto L_0x030c
            r21 = 1
            r5 = 1
            r4 = 6
            r22 = r4
        L_0x0309:
            r37 = r5
            goto L_0x0335
        L_0x030c:
            r4 = 3
            if (r8 != r4) goto L_0x0335
            r21 = 1
            r5 = 1
            r4 = 4
            if (r58 != 0) goto L_0x031d
            int r2 = r0.mResolvedDimensionRatioSide
            r0 = -1
            if (r2 == r0) goto L_0x031d
            if (r19 > 0) goto L_0x031d
            r4 = 6
        L_0x031d:
            int r0 = r51.getMargin()
            r10.addEquality(r7, r11, r0, r4)
            int r0 = r52.getMargin()
            int r0 = -r0
            r10.addEquality(r6, r1, r0, r4)
            goto L_0x0309
        L_0x032d:
            r37 = r5
            r38 = r11
            r11 = r35
            r21 = 1
        L_0x0335:
            r0 = 5
            r23 = 5
            r24 = r46
            r25 = r46
            if (r21 == 0) goto L_0x0388
            int r4 = r51.getMargin()
            int r26 = r52.getMargin()
            r5 = r1
            r1 = r10
            r39 = r0
            r0 = r47
            r2 = r7
            r40 = r12
            r12 = r3
            r3 = r11
            r14 = 0
            r41 = r5
            r14 = 6
            r5 = r57
            r42 = r6
            r6 = r41
            r14 = r7
            r7 = r42
            r27 = r8
            r8 = r26
            r43 = r9
            r9 = r22
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r13.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r1.mOwner
            boolean r1 = r1 instanceof android.support.constraint.solver.widgets.Barrier
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r12.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.mOwner
            boolean r2 = r2 instanceof android.support.constraint.solver.widgets.Barrier
            if (r1 == 0) goto L_0x037e
            if (r2 != 0) goto L_0x037e
            r23 = 6
            r25 = 1
            goto L_0x0398
        L_0x037e:
            if (r1 != 0) goto L_0x0398
            if (r2 == 0) goto L_0x0398
            r3 = 6
            r24 = 1
            r39 = r3
            goto L_0x0398
        L_0x0388:
            r39 = r0
            r41 = r1
            r42 = r6
            r14 = r7
            r27 = r8
            r43 = r9
            r40 = r12
            r0 = r47
            r12 = r3
        L_0x0398:
            if (r37 == 0) goto L_0x039e
            r39 = 6
            r23 = 6
        L_0x039e:
            r2 = r23
            r1 = r39
            if (r16 != 0) goto L_0x03a6
            if (r24 != 0) goto L_0x03a8
        L_0x03a6:
            if (r37 == 0) goto L_0x03af
        L_0x03a8:
            int r3 = r51.getMargin()
            r10.addGreaterThan(r14, r11, r3, r1)
        L_0x03af:
            if (r16 != 0) goto L_0x03b3
            if (r25 != 0) goto L_0x03b5
        L_0x03b3:
            if (r37 == 0) goto L_0x03c2
        L_0x03b5:
            int r3 = r52.getMargin()
            int r3 = -r3
            r5 = r41
            r4 = r42
            r10.addLowerThan(r4, r5, r3, r2)
            goto L_0x03c6
        L_0x03c2:
            r5 = r41
            r4 = r42
        L_0x03c6:
            if (r46 == 0) goto L_0x03ce
            r3 = 6
            r6 = 0
            r10.addGreaterThan(r14, r0, r6, r3)
            goto L_0x03e2
        L_0x03ce:
            r3 = 6
            r6 = 0
            goto L_0x03e2
        L_0x03d1:
            r5 = r1
            r0 = r2
            r4 = r6
            r14 = r7
            r27 = r8
            r43 = r9
            r38 = r11
            r40 = r12
            r11 = r35
            r6 = 0
            r12 = r3
            r3 = 6
        L_0x03e2:
            if (r46 == 0) goto L_0x03eb
            r1 = r48
            r2 = 0
            r10.addGreaterThan(r1, r4, r2, r3)
            goto L_0x03ed
        L_0x03eb:
            r1 = r48
        L_0x03ed:
            return
        L_0x03ee:
            r4 = r6
            r14 = r7
            r27 = r8
            r43 = r9
            r38 = r11
            r40 = r12
            r5 = r33
            r11 = r35
            r0 = r47
            r1 = r48
            r2 = 0
            r3 = 6
            r6 = 2
            r12 = r52
        L_0x0405:
            r7 = r43
            if (r7 >= r6) goto L_0x0411
            if (r46 == 0) goto L_0x0411
            r10.addGreaterThan(r14, r0, r2, r3)
            r10.addGreaterThan(r1, r4, r2, r3)
        L_0x0411:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.applyConstraints(android.support.constraint.solver.LinearSystem, boolean, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, android.support.constraint.solver.widgets.ConstraintAnchor, android.support.constraint.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    public void updateFromSolver(LinearSystem system) {
        int left = system.getObjectVariableValue(this.mLeft);
        int top = system.getObjectVariableValue(this.mTop);
        int right = system.getObjectVariableValue(this.mRight);
        int bottom = system.getObjectVariableValue(this.mBottom);
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        setFrame(left, top, right, bottom);
    }
}
