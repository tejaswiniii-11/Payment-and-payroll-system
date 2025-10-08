package com.aurionpro.payrollsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Configuration class to set up a non-web-specific Thymeleaf Template Engine.
 * This is necessary for generating HTML content (like payslips) from templates
 * that are not served directly via a controller.
 */
@Configuration
public class ThymeleafConfig {

	/**
	 * Creates a standard Thymeleaf Template Engine (non-Spring integration
	 * specific). This is the bean that is injected into PayslipServiceImpl.
	 */
	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.setEnableSpringELCompiler(true);
		// Optional: add message source if you use i18n in templates
		// templateEngine.setMessageSource(messageSource());
		return templateEngine;
	}

	/**
	 * Configures where Thymeleaf should look for the HTML templates (e.g.,
	 * payslip_template.html).
	 */
	@Bean
	public ITemplateResolver templateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		// This sets the prefix to the standard 'src/main/resources/templates' directory
		templateResolver.setPrefix("templates/");

		// Templates will have the .html suffix
		templateResolver.setSuffix(".html");

		// Use HTML5 mode for processing
		templateResolver.setTemplateMode(TemplateMode.HTML);

		// Whether template changes should be checked and templates reloaded
		templateResolver.setCacheable(false);

		return templateResolver;
	}
}
