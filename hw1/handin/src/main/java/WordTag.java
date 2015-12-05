

/* First created by JCasGen Sat Sep 20 06:08:17 EDT 2014 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Sep 22 02:26:11 EDT 2014
 * XML source: /home/ronhe/git/hw1-longh/src/main/resources/casConsumerDescriptor.xml
 * @generated */
public class WordTag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(WordTag.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected WordTag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public WordTag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public WordTag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public WordTag(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "WordTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WordTag_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "WordTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((WordTag_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets 
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "WordTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WordTag_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "WordTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((WordTag_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: begin0

  /** getter for begin0 - gets 
   * @generated
   * @return value of the feature 
   */
  public int getBegin0() {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_begin0 == null)
      jcasType.jcas.throwFeatMissing("begin0", "WordTag");
    return jcasType.ll_cas.ll_getIntValue(addr, ((WordTag_Type)jcasType).casFeatCode_begin0);}
    
  /** setter for begin0 - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setBegin0(int v) {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_begin0 == null)
      jcasType.jcas.throwFeatMissing("begin0", "WordTag");
    jcasType.ll_cas.ll_setIntValue(addr, ((WordTag_Type)jcasType).casFeatCode_begin0, v);}    
   
    
  //*--------------*
  //* Feature: end0

  /** getter for end0 - gets 
   * @generated
   * @return value of the feature 
   */
  public int getEnd0() {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_end0 == null)
      jcasType.jcas.throwFeatMissing("end0", "WordTag");
    return jcasType.ll_cas.ll_getIntValue(addr, ((WordTag_Type)jcasType).casFeatCode_end0);}
    
  /** setter for end0 - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEnd0(int v) {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_end0 == null)
      jcasType.jcas.throwFeatMissing("end0", "WordTag");
    jcasType.ll_cas.ll_setIntValue(addr, ((WordTag_Type)jcasType).casFeatCode_end0, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "WordTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WordTag_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (WordTag_Type.featOkTst && ((WordTag_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "WordTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((WordTag_Type)jcasType).casFeatCode_name, v);}    
  }

    