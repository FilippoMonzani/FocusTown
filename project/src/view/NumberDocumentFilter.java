package view;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * The {@link NumberDocumentFilter} class is a custom {@link DocumentFilter} used to restrict the input
 * of a text field to numeric characters only. It ensures that only digits (0-9) can be entered by the user,
 * preventing non-numeric characters from being inserted or replaced within the document.
 * 
 * <p>This filter provides feedback by emitting a beep using the {@link Toolkit} whenever a non-numeric
 * character is attempted to be entered.</p>
 * 
 * <p>Key Features:
 * <ul>
 *     <li>Restricts input to digits only, ensuring valid numerical entries.</li>
 *     <li>Provides visual feedback by emitting a beep when invalid characters are entered.</li>
 * </ul>
 * </p>
 */
public class NumberDocumentFilter extends DocumentFilter implements View{
	
	/**
     * Inserts a string into the document if the string consists only of numeric characters.
     * If the string contains any non-numeric characters, the insert operation is ignored and a beep sound
     * is played as feedback to the user.
     * 
     * @param fp the filter bypass, allowing direct modification of the document
     * @param offset the offset in the document where the insertion will take place
     * @param string the string to be inserted
     * @param aset the set of attributes to be applied to the inserted string
     * @throws BadLocationException if the insert operation is invalid at the specified offset
     */
	@Override
	public void insertString(DocumentFilter.FilterBypass fp, int offset, String string, AttributeSet aset)
			throws BadLocationException {
		int len = string.length();
		boolean isValidInteger = true;

		for (int i = 0; i < len; i++) {
			if (!Character.isDigit(string.charAt(i))) {
				isValidInteger = false;
				break;
			}
		}
		if (isValidInteger)
			super.insertString(fp, offset, string, aset);
		else
			Toolkit.getDefaultToolkit().beep();
	}

	/**
     * Replaces part of the document with a new string if the string consists only of numeric characters.
     * If the string contains any non-numeric characters, the replace operation is ignored, and a beep sound
     * is played as feedback to the user.
     * 
     * @param fp the filter bypass, allowing direct modification of the document
     * @param offset the offset in the document where the replacement will take place
     * @param length the length of the text to be replaced
     * @param string the string to replace the text with
     * @param aset the set of attributes to be applied to the replaced string
     * @throws BadLocationException if the replace operation is invalid at the specified offset
     */
	@Override
	    public void replace(DocumentFilter.FilterBypass fp, int offset
	                    , int length, String string, AttributeSet aset)
	                                        throws BadLocationException
	    {
	        int len = string.length();
	        boolean isValidInteger = true;

	        for (int i = 0; i < len; i++)
	        {
	            if (!Character.isDigit(string.charAt(i)))
	            {
	                isValidInteger = false;
	                break;
	            }
	        }
	        if (isValidInteger)
	            super.replace(fp, offset, length, string, aset);
	        else
	            Toolkit.getDefaultToolkit().beep();
	    }
}
