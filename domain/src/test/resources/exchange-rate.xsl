<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

    <xsl:template match="/DailyExRates">
        <dailyExchangeRates xmlns="http://www.newsoft.com/kurs/schemas"
                            rateDate="{/DailyExRates/@Date}">
            <xsl:for-each select="/DailyExRates/Currency">
                <xsl:element name="currencyRate">
                    <!-- xsl:attribute name="id">
                        <xsl:value-of select="@Id"/>
                    </xsl:attribute -->
                    <xsl:attribute name="code">
                        <xsl:value-of select="CharCode"/>
                    </xsl:attribute>
                    <xsl:attribute name="name">
                        <xsl:value-of select="Name"/>
                    </xsl:attribute>
                    <xsl:attribute name="rate">
                        <xsl:value-of select="Rate"/>
                    </xsl:attribute>                    
                </xsl:element>
            </xsl:for-each>
        </dailyExchangeRates>
    </xsl:template>
</xsl:stylesheet>
