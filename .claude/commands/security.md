Perform an OWASP Top 10 security check on the Mini Library Management System code I provide.

Check each of the following and report findings:

1. Injection — are user inputs sanitized before use in queries or commands?
2. Broken Authentication — are member login or admin routes protected properly?
3. Sensitive Data Exposure — are any passwords, tokens, or personal data exposed in logs or responses?
4. Broken Access Control — can a regular member access admin-only actions like deleting books?
5. Security Misconfiguration — are there hardcoded secrets, open CORS, or debug modes left on?
6. Insecure Dependencies — flag any npm/pip packages that are outdated or known vulnerable
7. XSS — if there is a frontend, are user inputs escaped before rendering?

For each finding report:
- OWASP category
- Risk level: HIGH / MEDIUM / LOW
- Exact location in code
- Recommended fix