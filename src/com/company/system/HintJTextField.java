package com.company.system;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * <p><b>Créé :</b> 06/05/2016</p>
 * <p><b>Modifié :</b> 06/12/2017</p>
 *
 * @author Pacôme Lehoux
 * @version 1.2
 * @since 1.0
 */
public class HintJTextField extends JTextField implements FocusListener {
	private String hint;

	private Color hintColor;

	private Color textColor;

	private boolean showingHint;

	public HintJTextField(String hint) {
		this(hint, new Color(176, 176, 176), Color.BLACK);
	}

	public HintJTextField(String hint, Color hintColor) {
		this(hint, hintColor, Color.BLACK);
	}

	public HintJTextField(String hint, Color hintColor, Color textColor) {
		super(hint);

		this.hint = hint;
		this.showingHint = true;
		this.hintColor = hintColor;
		this.textColor = textColor;
		this.setForeground(this.hintColor);

		this.setFont(new Font(this.getFont().getName(), Font.ITALIC, this.getFont().getSize()));
		this.setSize(30, (int) this.getPreferredSize().getHeight());
		this.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {

		if(this.getText().isEmpty()) {

			this.setText("");
			this.showingHint = false;

			this.setForeground(this.textColor);
			this.setFont(new Font(this.getFont().getName(), Font.PLAIN, this.getFont().getSize()));
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(this.getText().isEmpty()) clearText();
	}

	@Override
	public String getText() {
		return this.showingHint ? "" : super.getText();
	}

	public void clearText() {
		this.setText(this.hint);
		this.showingHint = true;

		this.setForeground(this.hintColor);
		this.setFont(new Font(this.getFont().getName(), Font.ITALIC, this.getFont().getSize()));
	}

	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public Color getHintColor() {
		return this.hintColor;
	}

	public void setHintColor(Color hintColor) {
		this.hintColor = hintColor;
	}

	public Color getTextColor() {
		return this.textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public boolean isShowingHint() {
		return this.showingHint;
	}
}
