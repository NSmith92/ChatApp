
package chatclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the chatclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TalkResponse_QNAME = new QName("http://ChatServer/", "talkResponse");
    private final static QName _Leave_QNAME = new QName("http://ChatServer/", "leave");
    private final static QName _ListenResponse_QNAME = new QName("http://ChatServer/", "listenResponse");
    private final static QName _LeaveResponse_QNAME = new QName("http://ChatServer/", "leaveResponse");
    private final static QName _Talk_QNAME = new QName("http://ChatServer/", "talk");
    private final static QName _Join_QNAME = new QName("http://ChatServer/", "join");
    private final static QName _JoinResponse_QNAME = new QName("http://ChatServer/", "joinResponse");
    private final static QName _Listen_QNAME = new QName("http://ChatServer/", "listen");
    private final static QName _Privatename_QNAME = new QName("http://ChatServer/", "privatename");
    private final static QName _PrivatenameResponse_QNAME = new QName("http://ChatServer/", "privatenameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: chatclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TalkResponse }
     * 
     */
    public TalkResponse createTalkResponse() {
        return new TalkResponse();
    }

    /**
     * Create an instance of {@link Leave }
     * 
     */
    public Leave createLeave() {
        return new Leave();
    }

    /**
     * Create an instance of {@link ListenResponse }
     * 
     */
    public ListenResponse createListenResponse() {
        return new ListenResponse();
    }

    /**
     * Create an instance of {@link LeaveResponse }
     * 
     */
    public LeaveResponse createLeaveResponse() {
        return new LeaveResponse();
    }

    /**
     * Create an instance of {@link Talk }
     * 
     */
    public Talk createTalk() {
        return new Talk();
    }

    /**
     * Create an instance of {@link Join }
     * 
     */
    public Join createJoin() {
        return new Join();
    }

    /**
     * Create an instance of {@link JoinResponse }
     * 
     */
    public JoinResponse createJoinResponse() {
        return new JoinResponse();
    }

    /**
     * Create an instance of {@link Listen }
     * 
     */
    public Listen createListen() {
        return new Listen();
    }

    /**
     * Create an instance of {@link Privatename }
     * 
     */
    public Privatename createPrivatename() {
        return new Privatename();
    }

    /**
     * Create an instance of {@link PrivatenameResponse }
     * 
     */
    public PrivatenameResponse createPrivatenameResponse() {
        return new PrivatenameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TalkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "talkResponse")
    public JAXBElement<TalkResponse> createTalkResponse(TalkResponse value) {
        return new JAXBElement<TalkResponse>(_TalkResponse_QNAME, TalkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Leave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "leave")
    public JAXBElement<Leave> createLeave(Leave value) {
        return new JAXBElement<Leave>(_Leave_QNAME, Leave.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "listenResponse")
    public JAXBElement<ListenResponse> createListenResponse(ListenResponse value) {
        return new JAXBElement<ListenResponse>(_ListenResponse_QNAME, ListenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "leaveResponse")
    public JAXBElement<LeaveResponse> createLeaveResponse(LeaveResponse value) {
        return new JAXBElement<LeaveResponse>(_LeaveResponse_QNAME, LeaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Talk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "talk")
    public JAXBElement<Talk> createTalk(Talk value) {
        return new JAXBElement<Talk>(_Talk_QNAME, Talk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Join }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "join")
    public JAXBElement<Join> createJoin(Join value) {
        return new JAXBElement<Join>(_Join_QNAME, Join.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "joinResponse")
    public JAXBElement<JoinResponse> createJoinResponse(JoinResponse value) {
        return new JAXBElement<JoinResponse>(_JoinResponse_QNAME, JoinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "listen")
    public JAXBElement<Listen> createListen(Listen value) {
        return new JAXBElement<Listen>(_Listen_QNAME, Listen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Privatename }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "privatename")
    public JAXBElement<Privatename> createPrivatename(Privatename value) {
        return new JAXBElement<Privatename>(_Privatename_QNAME, Privatename.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivatenameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ChatServer/", name = "privatenameResponse")
    public JAXBElement<PrivatenameResponse> createPrivatenameResponse(PrivatenameResponse value) {
        return new JAXBElement<PrivatenameResponse>(_PrivatenameResponse_QNAME, PrivatenameResponse.class, null, value);
    }

}
