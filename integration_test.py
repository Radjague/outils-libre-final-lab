import subprocess
import sys

def run_gradle():
    result = subprocess.run(
        ["gradlew.bat", "clean", "run", "-q", "--no-configuration-cache"],
        capture_output=True,
        text=True,
        cwd="."
    )
    return result.stdout.strip()

def test_output():
    print("Running integration test...")
    output = run_gradle()
    print(f"Output: {output}")

    expected = "Total: 455.175"

    if expected in output:
        print(f" PASSED: Found '{expected}'")
        return True
    else:
        print(f" FAILED: Expected '{expected}' but got '{output}'")
        return False

if __name__ == "__main__":
    success = test_output()
    sys.exit(0 if success else 1)