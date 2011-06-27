/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class Agents.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Agents implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _agentList.
     */
    private java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.Agent> _agentList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Agents() {
        super();
        this._agentList = new java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.Agent>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAgent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAgent(
            final com.taobao.caipiao.agentmock.generate.agent.config.Agent vAgent)
    throws java.lang.IndexOutOfBoundsException {
        this._agentList.addElement(vAgent);
    }

    /**
     * 
     * 
     * @param index
     * @param vAgent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAgent(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.Agent vAgent)
    throws java.lang.IndexOutOfBoundsException {
        this._agentList.add(index, vAgent);
    }

    /**
     * Method enumerateAgent.
     * 
     * @return an Enumeration over all
     * com.taobao.caipiao.agentmock.generate.agent.config.Agent
     * elements
     */
    public java.util.Enumeration<? extends com.taobao.caipiao.agentmock.generate.agent.config.Agent> enumerateAgent(
    ) {
        return this._agentList.elements();
    }

    /**
     * Method getAgent.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.taobao.caipiao.agentmock.generate.agent.config.Agent at
     * the given index
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Agent getAgent(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._agentList.size()) {
            throw new IndexOutOfBoundsException("getAgent: Index value '" + index + "' not in range [0.." + (this._agentList.size() - 1) + "]");
        }

        return (com.taobao.caipiao.agentmock.generate.agent.config.Agent) _agentList.get(index);
    }

    /**
     * Method getAgent.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Agent[] getAgent(
    ) {
        com.taobao.caipiao.agentmock.generate.agent.config.Agent[] array = new com.taobao.caipiao.agentmock.generate.agent.config.Agent[0];
        return (com.taobao.caipiao.agentmock.generate.agent.config.Agent[]) this._agentList.toArray(array);
    }

    /**
     * Method getAgentCount.
     * 
     * @return the size of this collection
     */
    public int getAgentCount(
    ) {
        return this._agentList.size();
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Method removeAgent.
     * 
     * @param vAgent
     * @return true if the object was removed from the collection.
     */
    public boolean removeAgent(
            final com.taobao.caipiao.agentmock.generate.agent.config.Agent vAgent) {
        boolean removed = _agentList.remove(vAgent);
        return removed;
    }

    /**
     * Method removeAgentAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Agent removeAgentAt(
            final int index) {
        java.lang.Object obj = this._agentList.remove(index);
        return (com.taobao.caipiao.agentmock.generate.agent.config.Agent) obj;
    }

    /**
     */
    public void removeAllAgent(
    ) {
        this._agentList.clear();
    }

    /**
     * 
     * 
     * @param index
     * @param vAgent
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAgent(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.Agent vAgent)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._agentList.size()) {
            throw new IndexOutOfBoundsException("setAgent: Index value '" + index + "' not in range [0.." + (this._agentList.size() - 1) + "]");
        }

        this._agentList.set(index, vAgent);
    }

    /**
     * 
     * 
     * @param vAgentArray
     */
    public void setAgent(
            final com.taobao.caipiao.agentmock.generate.agent.config.Agent[] vAgentArray) {
        //-- copy array
        _agentList.clear();

        for (int i = 0; i < vAgentArray.length; i++) {
                this._agentList.add(vAgentArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.taobao.caipiao.agentmock.generate.agent.config.Agents
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.Agents unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.Agents) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.Agents.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
