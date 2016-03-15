
public class SecretRoom extends HouseRoom {

	private boolean discovered;

	public SecretRoom(String name) {
		super(name);
		discovered = false;
	}

	public boolean getDiscovered() {
		return discovered;
	}

	public String discover() {
		String discovery = this.getRoomName() + " has been discovered.";
		discovered = true;
		return discovery;
	}
}
