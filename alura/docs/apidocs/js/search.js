document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.querySelector('.search-input');
    const sidebarLinks = document.querySelectorAll('.sidebar-nav a');
    const mainContent = document.querySelector('.main-content');
    const codeEditors = document.querySelectorAll(".code-editor");

    

    if (!searchInput || !sidebarLinks || !mainContent) {
        console.error('Missing one or more essential elements for the search functionality.');
        return;
    }

    searchInput.addEventListener('input', () => {
        const query = searchInput.value.toLowerCase();

        sidebarLinks.forEach(link => {
            const sectionTitle = link.textContent.toLowerCase();
            const sectionId = link.getAttribute('href').substring(1);
            const section = document.getElementById(sectionId);

            if (sectionTitle.includes(query) || section?.textContent.toLowerCase().includes(query)) {
                link.style.display = 'block';
                section?.classList.remove('hidden');
            } else {
                link.style.display = 'none';
                section?.classList.add('hidden');
            }
        });

        if (!query) {
            sidebarLinks.forEach(link => link.style.display = 'block');
            document.querySelectorAll('.main-content section').forEach(section => section.classList.remove('hidden'));
        }
    });


     codeEditors.forEach(editor => {
         const copyIcon = editor.querySelector(".icon");
         const codeContent = editor.querySelector(".editor-content .code");
 
         if (copyIcon && codeContent) {
             copyIcon.addEventListener("click", () => {
                 const textToCopy = codeContent.innerText; 
                 navigator.clipboard.writeText(textToCopy)
                     .then(() => {
                         Swal.fire({
                             icon: "success",
                             title: "Copied!",
                             text: "Code has been copied to clipboard.",
                             timer: 2000,
                             showConfirmButton: false
                         });
                     })
                     .catch(() => {
                         Swal.fire({
                             icon: "error",
                             title: "Error!",
                             text: "Failed to copy the code.",
                             timer: 2000,
                             showConfirmButton: false
                         });
                     });
             });
         }
     });
});
