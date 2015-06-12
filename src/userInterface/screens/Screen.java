package userInterface.screens;

public interface Screen extends UIDrawContainer {
	String[] toASCII();

        @Override
	void accept(UIElement element);
}
