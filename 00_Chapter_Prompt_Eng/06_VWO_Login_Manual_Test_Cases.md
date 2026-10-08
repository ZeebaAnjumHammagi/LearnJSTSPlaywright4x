# VWO Login Manual Test Cases

## Product Context
- Product: VWO / Wingify
- Feature: Login page
- Source: Attached VWO PRD
- Scope: Login page validation only
- Objective: Validate secure, correct, and consistent login behavior for valid and invalid credentials based on the PRD security and enterprise access requirements

## Assumptions and Gaps
- Exact username/email field label is not specified in the PRD.
- Exact password policy and validation messages are not specified in the PRD.
- Redirect destination after successful login is not specified in the PRD.
- MFA, SSO, forgot password, and remember-me behavior are not explicitly defined in the PRD.
- These items are treated as missing requirements and should be confirmed before execution.

## Manual Test Cases

### TC-VWO-LOGIN-001: Successful login with valid credentials
- Test ID: TC-VWO-LOGIN-001
- Title: Successful login with valid credentials
- Preconditions:
  - VWO login page is available and accessible
  - A valid active user account exists
  - The user has necessary access rights
- Steps:
  1. Open the VWO login page.
  2. Enter a valid username/email.
  3. Enter the correct password.
  4. Click the login button.
- Expected Result:
  - The user is successfully authenticated.
  - The system grants access to the authenticated area.
  - The user is redirected to the correct post-login destination as defined by the product flow.

### TC-VWO-LOGIN-002: Login attempt with invalid password
- Test ID: TC-VWO-LOGIN-002
- Title: Invalid password is rejected
- Preconditions:
  - A valid username/email is known
  - The account is active
- Steps:
  1. Open the VWO login page.
  2. Enter a valid username/email.
  3. Enter an incorrect password.
  4. Click the login button.
- Expected Result:
  - Login fails.
  - The user remains unauthenticated.
  - An appropriate error message is displayed.
  - No authenticated session is created.

### TC-VWO-LOGIN-003: Login attempt with invalid username/email
- Test ID: TC-VWO-LOGIN-003
- Title: Invalid username/email is rejected
- Preconditions:
  - An invalid or unregistered username/email is available
- Steps:
  1. Open the VWO login page.
  2. Enter an invalid or unknown username/email.
  3. Enter a valid or invalid password.
  4. Click the login button.
- Expected Result:
  - Login fails.
  - The user remains unauthenticated.
  - Access is denied.
  - No authenticated session is created.

### TC-VWO-LOGIN-004: Login with both username/email and password empty
- Test ID: TC-VWO-LOGIN-004
- Title: Empty credentials are blocked
- Preconditions:
  - The login page is loaded
- Steps:
  1. Open the VWO login page.
  2. Leave the username/email field empty.
  3. Leave the password field empty.
  4. Click the login button.
- Expected Result:
  - The form is not submitted.
  - Required-field validation is shown.
  - No authenticated session is established.

### TC-VWO-LOGIN-005: Login with empty password
- Test ID: TC-VWO-LOGIN-005
- Title: Empty password is blocked
- Preconditions:
  - A valid username/email is known
- Steps:
  1. Open the VWO login page.
  2. Enter a valid username/email.
  3. Leave the password field empty.
  4. Click the login button.
- Expected Result:
  - Login is blocked.
  - Validation is displayed for the password field.
  - No session is created.

### TC-VWO-LOGIN-006: Login with empty username/email
- Test ID: TC-VWO-LOGIN-006
- Title: Empty username/email is blocked
- Preconditions:
  - A valid password is known
- Steps:
  1. Open the VWO login page.
  2. Leave the username/email field empty.
  3. Enter a valid password.
  4. Click the login button.
- Expected Result:
  - Login is blocked.
  - Validation is displayed for the username/email field.
  - No session is created.

### TC-VWO-LOGIN-007: Login with malformed username/email format
- Test ID: TC-VWO-LOGIN-007
- Title: Malformed username/email format is rejected
- Preconditions:
  - A valid password is available
- Steps:
  1. Open the VWO login page.
  2. Enter a malformed username/email value.
  3. Enter a valid password.
  4. Click the login button.
- Expected Result:
  - Login fails or validation error is displayed according to the product rules.
  - No authenticated session is created.

### TC-VWO-LOGIN-008: Password field is masked or protected as designed
- Test ID: TC-VWO-LOGIN-008
- Title: Password field behaves securely
- Preconditions:
  - Login page is loaded
- Steps:
  1. Open the VWO login page.
  2. Enter a password into the password field.
  3. Observe how the password is displayed or masked.
- Expected Result:
  - The password is not displayed in plain text in a way that violates secure UI behavior.
  - The field behaves according to product design and enterprise security expectations.

### TC-VWO-LOGIN-009: Unauthorized user cannot access the app
- Test ID: TC-VWO-LOGIN-009
- Title: Unauthorized user is denied access
- Preconditions:
  - A restricted or unauthorized user account exists
- Steps:
  1. Open the VWO login page.
  2. Enter unauthorized user credentials.
  3. Click login.
- Expected Result:
  - Login is denied or access is restricted according to RBAC requirements.
  - No unauthorized access is granted.

### TC-VWO-LOGIN-010: Repeated invalid login attempts trigger security handling
- Test ID: TC-VWO-LOGIN-010
- Title: Repeated invalid attempts follow security policy
- Preconditions:
  - Retry or lockout behavior is configured for the environment
- Steps:
  1. Open the VWO login page.
  2. Enter invalid credentials repeatedly.
  3. Observe the system behavior after multiple failed attempts.
- Expected Result:
  - The system applies the configured security policy, such as retry delay, lockout, or block behavior.
  - No unauthorized access is granted.

### TC-VWO-LOGIN-011: 2FA is required when enabled
- Test ID: TC-VWO-LOGIN-011
- Title: Two-factor authentication validation when enabled
- Preconditions:
  - 2FA is enabled for the user or environment
- Steps:
  1. Open the VWO login page.
  2. Enter valid username/email and password.
  3. Observe the authentication flow.
  4. Complete the second factor if prompted.
- Expected Result:
  - The user cannot complete login without valid second-factor confirmation.
  - Authentication succeeds only after successful 2FA verification.

### TC-VWO-LOGIN-012: Session persists according to configured policy
- Test ID: TC-VWO-LOGIN-012
- Title: Session persistence after successful login
- Preconditions:
  - User has logged in successfully
- Steps:
  1. Log in with valid credentials.
  2. Refresh the browser or reopen the session after a short interval.
- Expected Result:
  - Session behavior matches the product’s defined session policy.
  - If the session is valid, the user remains authenticated as designed.

### TC-VWO-LOGIN-013: Logout ends the authenticated session
- Test ID: TC-VWO-LOGIN-013
- Title: Logout clears access correctly
- Preconditions:
  - User is signed in to the application
- Steps:
  1. Log in successfully.
  2. Click the logout option.
  3. Attempt to access protected content again.
- Expected Result:
  - The user is logged out successfully.
  - Protected pages require re-authentication.
  - No unauthorized access remains after logout.

### TC-VWO-LOGIN-014: Direct access to protected page without login is denied
- Test ID: TC-VWO-LOGIN-014
- Title: Protected pages are not accessible without authentication
- Preconditions:
  - User is not logged in
- Steps:
  1. Open a protected page or route directly without authenticating.
- Expected Result:
  - Access is denied.
  - The user is redirected or shown an access error message.

## Priority Legend
- P0: Critical authentication or access-control scenario
- P1: Important validation or security scenario

## Summary
These manual test cases are aligned to the attached VWO PRD and the enterprise access/security expectations it contains. Details not explicitly provided in the PRD, such as exact validation text or MFA specifics, are treated as missing requirements and should be confirmed before final execution.
