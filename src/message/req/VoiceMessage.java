package message.req;

public class VoiceMessage extends BaseMessage {
	private String MediaId; //√ΩÃÂID
	private String Format;  //”Ô“Ù∏Ò Ω
	
	public String getMediaId(){
		return MediaId;
	}
	
	public void setMediaId(String mediaId){
		MediaId = mediaId;
	}
	
	public String getFormat(){
		return Format;
	}
	
	public void setFormat(String format){
		Format = format;
	}
	
}
