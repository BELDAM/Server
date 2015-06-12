package userInterface;

public abstract class Screen implements UIDrawable, UIDrawContainer {
	public abstract void accept(UIElement element);
}
