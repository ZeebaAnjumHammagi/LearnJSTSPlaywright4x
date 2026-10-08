# Wingify Login Test Cases (Jira Style)

## Product Context
- Product: VWO / Wingify
- Feature: Login authentication
- Source: Attached PRD for VWO – Digital Experience Optimization Platform
- Scope: Valid and invalid login credentials, secure access, and enterprise login behavior

## Assumptions and Gaps
- Exact username/email field label is not specified in the PRD.
- Exact password policy, error messages, and redirect target are not specified in the PRD.
- MFA and SSO behavior are not explicitly detailed; validate separately if enabled.
- Role mapping and access restrictions are not fully specified in the PRD.

## Test Case Table

| Test ID | Title | Priority | Preconditions | Steps | Expected Result |
| --- | --- | --- | --- | --- | --- |
| WL-01 | Login with valid credentials | P0 | User account exists and is active; user has valid access rights | 1. Open Wingify login page. 2. Enter valid username/email. 3. Enter valid password. 4. Click login. | User is successfully authenticated and redirected to the correct landing page or dashboard. |
| WL-02 | Login with invalid password | P0 | Valid username/email is known; account is active | 1. Open login page. 2. Enter valid username/email. 3. Enter wrong password. 4. Click login. | Login fails. User remains unauthenticated. Appropriate error message is displayed. No session is created. |
| WL-03 | Login with invalid username/email | P0 | User account does not exist or is invalid | 1. Open login page. 2. Enter invalid username/email. 3. Enter valid or invalid password. 4. Click login. | Login fails. User remains unauthenticated. Access is denied. |
| WL-04 | Login with empty username and password | P0 | None | 1. Open login page. 2. Leave username/email empty. 3. Leave password empty. 4. Click login. | Submission is blocked. Required field validation is shown. No authenticated session is created. |
| WL-05 | Login with empty password | P1 | Valid username/email is known | 1. Open login page. 2. Enter valid username/email. 3. Leave password empty. 4. Click login. | Login is blocked. Validation error is shown. No session is created. |
| WL-06 | Login with empty username/email | P1 | Valid password is known | 1. Open login page. 2. Leave username/email empty. 3. Enter valid password. 4. Click login. | Login is blocked. Validation error is shown. No session is created. |
| WL-07 | Login with malformed username/email format | P1 | Username/email format validation is expected by product behavior | 1. Open login page. 2. Enter malformed username/email value. 3. Enter valid password. 4. Click login. | Login fails or validation error appears according to product validation rules. No session is created. |
| WL-08 | Password masking and secure field behavior | P1 | Login page is loaded | 1. Open login page. 2. Enter password. 3. Observe password field behavior. | Password is masked or handled securely according to product design. No credential leakage is observed in UI or logs. |
| WL-09 | Unauthorized user login | P0 | Restricted or unauthorized account exists | 1. Open login page. 2. Enter unauthorized user credentials. 3. Click login. | User is denied access according to RBAC and enterprise security policies. |
| WL-10 | Login with repeated invalid attempts | P1 | Account is configured for retry behavior | 1. Open login page. 2. Enter wrong credentials multiple times. | Product-specific lockout, retry, delay, or error handling behavior occurs as defined by security policy. |
| WL-11 | 2FA validation when enabled | P0 | 2FA is enabled for the environment or role | 1. Log in with valid credentials. 2. Complete second-factor verification if prompted. | Authentication succeeds only after correct second-factor verification. |
| WL-12 | Session persistence after successful login | P1 | Valid login has succeeded | 1. Log in successfully. 2. Refresh the browser or reopen the app. | Session behavior matches secure product design; user remains authenticated if the session policy allows it. |
| WL-13 | Logout from authenticated session | P0 | User is already logged in | 1. Log in successfully. 2. Click logout. 3. Attempt to access protected content. | User is logged out successfully. Protected areas require re-authentication. |
| WL-14 | Access protected page without login | P0 | User is not authenticated | 1. Open a protected page directly without logging in. | Access is denied and user is redirected or shown an access error page. |

## Priority Legend
- P0: Critical login/access validation that blocks access or causes security risk
- P1: Important business or validation flow that may affect user experience or policy enforcement

## Summary
This test case set aligns with the verified VWO PRD facts for enterprise-grade access control, user security, login reliability, and product usage. Missing product-level specifics such as exact validation rules, error text, redirect destinations, and MFA configuration have been explicitly called out as gaps rather than guessed.
