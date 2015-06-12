package userInterface;

public interface Screen extends UIDrawContainer {
	String[] toAscii();

	void accept(UIElement element);
}
