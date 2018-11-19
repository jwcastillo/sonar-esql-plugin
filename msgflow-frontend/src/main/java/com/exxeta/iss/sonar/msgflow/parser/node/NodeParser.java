package com.exxeta.iss.sonar.msgflow.parser.node;

import static com.exxeta.iss.sonar.msgflow.parser.ParserUtils.getXPathString;

import javax.xml.xpath.XPathExpressionException;

import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;
import org.w3c.dom.Element;

import com.exxeta.iss.sonar.msgflow.tree.impl.AbstractMessageFlowNode;

public abstract class NodeParser<T extends AbstractMessageFlowNode> {
	private static final Logger LOGGER = Loggers.get(NodeParser.class);

	protected String getId(final Element nodeElement) throws XPathExpressionException {
		return nodeElement.getAttribute("xmi:id");
	}

	protected int getLocationX(final Element nodeElement) throws XPathExpressionException {
		return Integer.parseInt(nodeElement.getAttribute("location").split(",")[0]);
	}

	protected int getLocationY(final Element nodeElement) throws XPathExpressionException {
		return Integer.parseInt(nodeElement.getAttribute("location").split(",")[1]);
	}

	protected String getName(final Element nodeElement) throws XPathExpressionException {
		return getXPathString(nodeElement, "./translation/@string");
	}

	public abstract String getNodeType();

	public T parseMessageFlowNode(Element nodeElement) {
		try {
		return internalParse(nodeElement);
		} catch (XPathExpressionException e){
			LOGGER.error("Cannot parse node", e);
			return null;
		}
	}

	protected abstract T internalParse(Element nodeElement) throws XPathExpressionException;

}
